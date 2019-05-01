package poglavlje05.syntaxtree.visitor;

import poglavlje05.diagnostic.ErrorReport;
import poglavlje05.symboltable.Class;
import poglavlje05.symboltable.Method;
import poglavlje05.symboltable.Symbol;
import poglavlje05.symboltable.SymbolTable;
import poglavlje05.syntaxtree.MainClass;
import poglavlje05.syntaxtree.classdecl.ClassDeclExtends;
import poglavlje05.syntaxtree.classdecl.ClassDeclSimple;
import poglavlje05.syntaxtree.formal.Formal;
import poglavlje05.syntaxtree.methoddecl.MethodDecl;
import poglavlje05.syntaxtree.type.*;
import poglavlje05.syntaxtree.vardecl.VarDecl;

public class BuildSymbolTableTypeVisitor extends TypeDepthFirstVisitor {
    private SymbolTable symbolTable;
    private ErrorReport errReport;

    public BuildSymbolTableTypeVisitor() {
        this.symbolTable = new SymbolTable();
        this.errReport = new ErrorReport("symbol table building");
    }

    public SymbolTable getSymbolTable() {
        return this.symbolTable;
    }

    public ErrorReport getErrReport() {
        return errReport;
    }

    // for scopes
    private Class currentClass;
    private Method currentMethod;

    @Override
    public Type visit(MainClass n) {
        Symbol mainClassSymbol = Symbol.symbol(n.className.identifier);

        // Adding the main class to the symbol table
        this.symbolTable.addClass(mainClassSymbol, null);

        // Setting the current class for further scoping
        this.currentClass = this.symbolTable.getClass(mainClassSymbol);

        // To avoid having special classes for
        // "void" type and "String []" type
        // since these are the only occurences
        IdentifierType voidType = new IdentifierType("void");
        IdentifierType stringArrayType = new IdentifierType("String []");

        Method mainMethod = new Method(Symbol.symbol("main"), voidType);
        mainMethod.addVar(Symbol.symbol(n.argsName.identifier), stringArrayType);

        // Setting the current method for further scoping
        this.currentMethod = mainMethod;

        n.statement.accept(this);

        // Resetting the scope
        this.currentMethod = null;
        this.currentClass = null;

        return null;
    }

    @Override
    public Type visit(ClassDeclSimple n) {
        Symbol classNameSymbol = Symbol.symbol(n.className.identifier);

        if (!this.symbolTable.addClass(classNameSymbol, null)) {
            this.errReport.addError("Class " + n.className.identifier + " is already defined");
        }

        this.currentClass = this.symbolTable.getClass(classNameSymbol);

        for (int i = 0; i < n.varDeclList.size(); ++i) {
            n.varDeclList.elementAt(i).accept(this);
        }
        for (int i = 0; i < n.methodDeclList.size(); ++i) {
            n.methodDeclList.elementAt(i).accept(this);
        }

        // Resetting the scope
        this.currentClass = null;

        return null;
    }

    @Override
    public Type visit(ClassDeclExtends n) {
        Symbol classNameSymbol = Symbol.symbol(n.className.identifier);
        Symbol superNameSymbol = Symbol.symbol(n.superClassName.identifier);

        // Adding class to a symbol table
        if (!this.symbolTable.addClass(classNameSymbol, superNameSymbol)) {
            this.errReport.addError("Class " + n.className.identifier + " is already defined");
        }

        // Setting the current class for further scoping
        this.currentClass = this.symbolTable.getClass(classNameSymbol);

        for (int i = 0; i < n.varDeclList.size(); ++i) {
            n.varDeclList.elementAt(i).accept(this);
        }
        for (int i = 0; i < n.methodDeclList.size(); ++i) {
            n.methodDeclList.elementAt(i).accept(this);
        }

        // Resetting the scope
        this.currentClass = null;

        return null;
    }

    @Override
    public Type visit(VarDecl n) {
        Type t = n.varType.accept(this);
        String varId = n.varId.identifier;
        Symbol varSymbol = Symbol.symbol(varId);

        // Trying to add a variable to a method
        if (null != this.currentMethod) {
            if (!this.currentMethod.addVar(varSymbol, t)) {
                this.errReport.addError("Variable " + varId +
                        " is already defined in " + this.currentClass.getId().toString() +
                        "." + this.currentMethod.getId().toString());
            }
        }
        // Otherwise, try to add to a class
        else {
            if (!this.currentClass.addVar(varSymbol, t)) {
                this.errReport.addError("Variable " + varId +
                        " is already defined in " + this.currentClass.getId().toString());
            }
        }

        return null;
    }

    @Override
    public Type visit(MethodDecl n) {
        Type t = n.returnType.accept(this);
        String methodId = n.methodName.identifier;
        Symbol methodSymbol = Symbol.symbol(methodId);

        // Adding method to the currently scoped class
        if (!this.currentClass.addMethod(methodSymbol, t)) {
            this.errReport.addError("Method " + methodId +
                    " is already defined in " + this.currentClass.getId().toString());
        }

        // Setting the current method for further scoping
        this.currentMethod = this.currentClass.getMethod(methodSymbol);

        for (int i = 0; i < n.argsList.size(); ++i) {
            n.argsList.elementAt(i).accept(this);
        }
        for (int i = 0; i < n.varDeclList.size(); ++i) {
            n.varDeclList.elementAt(i).accept(this);
        }
        for (int i = 0; i < n.statementList.size(); ++i) {
            n.statementList.elementAt(i).accept(this);
        }

        n.returnValue.accept(this);

        // Resetting the scope
        this.currentMethod = null;

        return null;
    }

    @Override
    public Type visit(Formal n) {
        Type t = n.argType.accept(this);
        String formalId = n.argId.identifier;
        Symbol formalSymbol = Symbol.symbol(formalId);

        if (!this.currentMethod.addParam(formalSymbol, t)) {
            this.errReport.addError("Formal parameter " + formalId +
                    " is already defined in " + this.currentClass.getId().toString() +
                    "." + this.currentMethod.getId().toString());
        }

        return null;
    }

    @Override
    public Type visit(IntArrayType n) {
        return n;
    }

    @Override
    public Type visit(BooleanType n) {
        return n;
    }

    @Override
    public Type visit(IntType n) {
        return n;
    }

    @Override
    public Type visit(IdentifierType n) {
        return n;
    }
}
