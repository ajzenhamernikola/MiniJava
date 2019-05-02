package poglavlje05.visitor;

import poglavlje05.diagnostic.ErrorReport;
import poglavlje05.symboltable.Method;
import poglavlje05.symboltable.Symbol;
import poglavlje05.symboltable.SymbolTable;
import poglavlje05.syntaxtree.expression.*;
import poglavlje05.syntaxtree.type.*;

public class TypeCheckExpressionTDFVisitor extends TypeDepthFirstVisitor {
    private TypeCheckDFVisitor typeCheckDFVisitor;

    public TypeCheckExpressionTDFVisitor(TypeCheckDFVisitor typeCheckDFVisitor) {
        this.typeCheckDFVisitor = typeCheckDFVisitor;
    }

    @Override
    public Type visit(And n) {
        if (!(n.left.accept(this) instanceof BooleanType)) {
            this.typeCheckDFVisitor.getErrorReport().addError("Left side of operator && must be of type Boolean");
        }
        if (!(n.right.accept(this) instanceof BooleanType)) {
            this.typeCheckDFVisitor.getErrorReport().addError("Right side of operator && must be of type Boolean");
        }
        return new BooleanType();
    }

    @Override
    public Type visit(LessThan n) {
        if (!(n.left.accept(this) instanceof IntType)) {
            this.typeCheckDFVisitor.getErrorReport().addError("Left side of operator < must be of type Integer");
        }
        if (!(n.right.accept(this) instanceof IntType)) {
            this.typeCheckDFVisitor.getErrorReport().addError("Right side of operator < must be of type Integer");
        }
        return new BooleanType();
    }

    @Override
    public Type visit(Plus n) {
        if (!(n.left.accept(this) instanceof IntType)) {
            this.typeCheckDFVisitor.getErrorReport().addError("Left side of operator + must be of type Integer");
        }
        if (!(n.right.accept(this) instanceof IntType)) {
            this.typeCheckDFVisitor.getErrorReport().addError("Right side of operator + must be of type Integer");
        }
        return new IntType();
    }

    @Override
    public Type visit(Minus n) {
        if (!(n.left.accept(this) instanceof IntType)) {
            this.typeCheckDFVisitor.getErrorReport().addError("Left side of operator - must be of type Integer");
        }
        if (!(n.right.accept(this) instanceof IntType)) {
            this.typeCheckDFVisitor.getErrorReport().addError("Right side of operator - must be of type Integer");
        }
        return new IntType();
    }

    @Override
    public Type visit(Times n) {
        if (!(n.left.accept(this) instanceof IntType)) {
            this.typeCheckDFVisitor.getErrorReport().addError("Left side of operator * must be of type Integer");
        }
        if (!(n.right.accept(this) instanceof IntType)) {
            this.typeCheckDFVisitor.getErrorReport().addError("Right side of operator * must be of type Integer");
        }
        return new IntType();
    }

    @Override
    public Type visit(Div n) {
        if (!(n.left.accept(this) instanceof IntType)) {
            this.typeCheckDFVisitor.getErrorReport().addError("Left side of operator / must be of type Integer");
        }
        if (!(n.right.accept(this) instanceof IntType)) {
            this.typeCheckDFVisitor.getErrorReport().addError("Right side of operator / must be of type Integer");
        }
        return new IntType();
    }

    @Override
    public Type visit(ArrayLookup n) {
        if (!(n.arrayExp.accept(this) instanceof IntArrayType)) {
            this.typeCheckDFVisitor.getErrorReport().addError("Operator [] must be applied on an Integer []");
        }
        if (!(n.indexExp.accept(this) instanceof IntType)) {
            this.typeCheckDFVisitor.getErrorReport().addError("Index value of operator [] must be of type Integer");
        }
        return new IntType();
    }

    @Override
    public Type visit(ArrayLength n) {
        if (!(n.arrayExp.accept(this) instanceof IntArrayType)) {
            this.typeCheckDFVisitor.getErrorReport().addError("Operator length must be applied on an Integer []");
        }
        return new IntType();
    }

    @Override
    public Type visit(Call n) {
        String methodName = n.methodName.identifier;
        Symbol methodSymbol = Symbol.symbol(methodName);

        if (!(n.object.accept(this) instanceof IdentifierType)) {
            this.typeCheckDFVisitor.getErrorReport().addError("Method " + methodName +
                    "called on something that is not a class or Object.");
        }

        String className = ((IdentifierType) n.object.accept(this)).identifier;
        Symbol classSymbol = Symbol.symbol(className);

        Method calledMethod = this.typeCheckDFVisitor.getSymbolTable().getMethod(methodSymbol, classSymbol);

        for (int i = 0; i < n.argsExp.size(); ++i) {
            Type t1 = null;
            Type t2;

            if (null != calledMethod.getParamAt(i)) {
                t1 = calledMethod.getParamAt(i).type();
            }

            t2 = n.argsExp.elementAt(i).accept(this);

            if (!this.typeCheckDFVisitor.getSymbolTable().compareTypes(t1,t2)) {
                this.typeCheckDFVisitor.getErrorReport().addError("Type Error in argument " + (i+1) +
                        " passed to " + className + "." + methodName);
            }
        }

        return this.typeCheckDFVisitor.getSymbolTable().getMethodType(methodSymbol, classSymbol);
    }

    @Override
    public Type visit(IntegerLiteral n) {
        return new IntType();
    }

    @Override
    public Type visit(True n) {
        return new BooleanType();
    }

    @Override
    public Type visit(False n) {
        return new BooleanType();
    }

    @Override
    public Type visit(IdentifierExp n) {
        return this.typeCheckDFVisitor.getSymbolTable().getVarType(
                this.typeCheckDFVisitor.getCurrentMethod(),
                this.typeCheckDFVisitor.getCurrentClass(),
                Symbol.symbol(n.identifier));
    }

    @Override
    public Type visit(This n) {
        return this.typeCheckDFVisitor.getCurrentClass().type();
    }

    @Override
    public Type visit(NewArray n) {
        if (!(n.arraySize.accept(this) instanceof IntType)) {
            this.typeCheckDFVisitor.getErrorReport().addError("Array size must be of type Integer");
        }

        return new IntArrayType();
    }

    @Override
    public Type visit(NewObject n) {
        return new IdentifierType(n.className.identifier);
    }

    @Override
    public Type visit(Not n) {
        if (!(n.value.accept(this) instanceof BooleanType)) {
            this.typeCheckDFVisitor.getErrorReport().addError("Operator ! must be applied to a Boolean type");
        }

        return new BooleanType();
    }
}
