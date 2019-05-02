package poglavlje05.visitor;

import poglavlje05.diagnostic.ErrorReport;
import poglavlje05.symboltable.Class;
import poglavlje05.symboltable.Method;
import poglavlje05.symboltable.Symbol;
import poglavlje05.symboltable.SymbolTable;
import poglavlje05.syntaxtree.MainClass;
import poglavlje05.syntaxtree.classdecl.ClassDeclExtends;
import poglavlje05.syntaxtree.classdecl.ClassDeclSimple;
import poglavlje05.syntaxtree.methoddecl.MethodDecl;
import poglavlje05.syntaxtree.statement.*;
import poglavlje05.syntaxtree.type.BooleanType;
import poglavlje05.syntaxtree.type.IntArrayType;
import poglavlje05.syntaxtree.type.IntType;
import poglavlje05.syntaxtree.type.Type;

public class TypeCheckDFVisitor extends DepthFirstVisitor {
    private Class currentClass;
    private Method currentMethod;
    private SymbolTable symbolTable;
    private ErrorReport errorReport;

    public TypeCheckDFVisitor(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
        this.errorReport = new ErrorReport("typechecking");
    }

    Class getCurrentClass() {
        return this.currentClass;
    }

    Method getCurrentMethod() {
        return this.currentMethod;
    }

    SymbolTable getSymbolTable() {
        return this.symbolTable;
    }

    public ErrorReport getErrorReport() {
        return errorReport;
    }

    @Override
    public void visit(MainClass n) {
        n.className.accept(this);
        String mainClassId = n.className.identifier;
        Symbol mainClassSymbol = Symbol.symbol(mainClassId);

        // Scoping
        this.currentClass = this.symbolTable.getClass(mainClassSymbol);

        n.argsName.accept(this);
        n.statement.accept(this);

        this.currentClass = null;
    }

    @Override
    public void visit(ClassDeclSimple n) {
        n.className.accept(this);
        String classId = n.className.identifier;
        Symbol classSymbol = Symbol.symbol(classId);

        // Scoping
        this.currentClass = this.symbolTable.getClass(classSymbol);

        for (int i = 0; i < n.varDeclList.size(); ++i) {
            n.varDeclList.elementAt(i).accept(this);
        }
        for (int i = 0; i < n.methodDeclList.size(); ++i) {
            n.methodDeclList.elementAt(i).accept(this);
        }

        this.currentClass = null;
    }

    @Override
    public void visit(ClassDeclExtends n) {
        n.className.accept(this);
        String classId = n.className.identifier;
        Symbol classSymbol = Symbol.symbol(classId);

        // Scoping
        this.currentClass = this.symbolTable.getClass(classSymbol);

        n.superClassName.accept(this);

        for (int i = 0; i < n.varDeclList.size(); ++i) {
            n.varDeclList.elementAt(i).accept(this);
        }
        for (int i = 0; i < n.methodDeclList.size(); ++i) {
            n.methodDeclList.elementAt(i).accept(this);
        }

        this.currentClass = null;
    }

    @Override
    public void visit(MethodDecl n) {
        n.methodName.accept(this);
        String methodId = n.methodName.identifier;
        Symbol methodSymbol = Symbol.symbol(methodId);

        // Scoping
        this.currentMethod = this.currentClass.getMethod(methodSymbol);

        n.returnType.accept(this);
        Type returnType = this.currentMethod.type();

        for ( int i = 0; i < n.argsList.size(); i++ ) {
            n.argsList.elementAt(i).accept(this);
        }
        for ( int i = 0; i < n.varDeclList.size(); i++ ) {
            n.varDeclList.elementAt(i).accept(this);
        }
        for ( int i = 0; i < n.statementList.size(); i++ ) {
            n.statementList.elementAt(i).accept(this);
        }

        // We are checking if the specified return type
        // and the return value have the same type
        if (!this.symbolTable.compareTypes(returnType, n.returnValue.accept(new TypeCheckExpressionTDFVisitor(this)))) {
            this.errorReport.addError("Incompatible return type for method " + methodId);
        }

        this.currentMethod = null;
    }

    @Override
    public void visit(If n) {
        if (! (n.condition.accept(new TypeCheckExpressionTDFVisitor(this)) instanceof BooleanType)) {
            this.errorReport.addError("The condition of if-statement must be of type Boolean");
        }

        n.trueStatement.accept(this);
        n.falseStatement.accept(this);
    }

    @Override
    public void visit(While n) {
        if (! (n.condition.accept(new TypeCheckExpressionTDFVisitor(this)) instanceof BooleanType)) {
            this.errorReport.addError("The condition of while-loop must be of type Boolean");
        }

        n.loopBody.accept(this);
    }

    @Override
    public void visit(Print n) {
        if (! (n.expression.accept(new TypeCheckExpressionTDFVisitor(this)) instanceof IntType)) {
            this.errorReport.addError("The condition of if-statement must be of type Integer");
        }
    }

    @Override
    public void visit(Assign n) {
        String lValueId = n.lValue.identifier;
        Symbol lValueSymbol = Symbol.symbol(lValueId);

        Type lType = this.symbolTable.getVarType(this.currentMethod, this.currentClass, lValueSymbol);
        Type rType = n.rValue.accept(new TypeCheckExpressionTDFVisitor(this));

        if (!this.symbolTable.compareTypes(lType, rType)) {
            this.errorReport.addError("Incompatible types for assignment to " + lValueId);
        }
    }

    @Override
    public void visit(ArrayAssign n) {
        String lValueId = n.arrayName.identifier;
        Symbol lValueSymbol = Symbol.symbol(lValueId);

        Type lType = this.symbolTable.getVarType(this.currentMethod, this.currentClass, lValueSymbol);

        if (!(lType instanceof IntArrayType)) {
            this.errorReport.addError("The identifier in an array assignment must be of type Integer []");
        }

        if (!(n.indexVal.accept(new TypeCheckExpressionTDFVisitor(this)) instanceof IntType)) {
            this.errorReport.addError("The first expression in an array assignment must be of type Integer");
        }
        if (!(n.rValue.accept(new TypeCheckExpressionTDFVisitor(this)) instanceof IntType) ) {
            this.errorReport.addError("The second expression in an array assignment must be of type Int");
        }
    }
}
