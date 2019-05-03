package poglavlje06.visitor;

import poglavlje06.syntaxtree.*;
import poglavlje06.syntaxtree.classdecl.*;
import poglavlje06.syntaxtree.expression.*;
import poglavlje06.syntaxtree.formal.*;
import poglavlje06.syntaxtree.methoddecl.*;
import poglavlje06.syntaxtree.statement.*;
import poglavlje06.syntaxtree.type.*;
import poglavlje06.syntaxtree.vardecl.*;

public class TypeDepthFirstVisitor implements TypeVisitor {

    @Override
    public Type visit(Program n) {
        n.mainClass.accept(this);
        for ( int i = 0; i < n.classDeclList.size(); i++ ) {
            n.classDeclList.elementAt(i).accept(this);
        }
        return null;
    }

    @Override
    public Type visit(MainClass n) {
        n.className.accept(this);
        n.argsName.accept(this);
        n.statement.accept(this);
        return null;
    }

    @Override
    public Type visit(ClassDeclSimple n) {
        n.className.accept(this);
        for ( int i = 0; i < n.varDeclList.size(); i++ ) {
            n.varDeclList.elementAt(i).accept(this);
        }
        for ( int i = 0; i < n.methodDeclList.size(); i++ ) {
            n.methodDeclList.elementAt(i).accept(this);
        }
        return null;
    }

    @Override
    public Type visit(ClassDeclExtends n) {
        n.className.accept(this);
        n.superClassName.accept(this);
        for ( int i = 0; i < n.varDeclList.size(); i++ ) {
            n.varDeclList.elementAt(i).accept(this);
        }
        for ( int i = 0; i < n.methodDeclList.size(); i++ ) {
            n.methodDeclList.elementAt(i).accept(this);
        }
        return null;
    }

    @Override
    public Type visit(VarDecl n) {
        n.varType.accept(this);
        n.varId.accept(this);
        return null;
    }

    @Override
    public Type visit(MethodDecl n) {
        n.returnType.accept(this);
        n.methodName.accept(this);
        for ( int i = 0; i < n.argsList.size(); i++ ) {
            n.argsList.elementAt(i).accept(this);
        }
        for ( int i = 0; i < n.varDeclList.size(); i++ ) {
            n.varDeclList.elementAt(i).accept(this);
        }
        for ( int i = 0; i < n.statementList.size(); i++ ) {
            n.statementList.elementAt(i).accept(this);
        }
        n.returnValue.accept(this);
        return null;
    }

    @Override
    public Type visit(Formal n) {
        n.argType.accept(this);
        n.argId.accept(this);
        return null;
    }

    @Override
    public Type visit(IntArrayType n) {
        return null;
    }

    @Override
    public Type visit(BooleanType n) {
        return null;
    }

    @Override
    public Type visit(IntType n) {
        return null;
    }

    @Override
    public Type visit(IdentifierType n) {
        return null;
    }

    @Override
    public Type visit(Block n) {
        for (int i = 0; i < n.statementList.size(); i++) {
            n.statementList.elementAt(i).accept(this);
        }
        return null;
    }

    @Override
    public Type visit(If n) {
        n.condition.accept(this);
        n.trueStatement.accept(this);
        n.falseStatement.accept(this);
        return null;
    }

    @Override
    public Type visit(While n) {
        n.condition.accept(this);
        n.loopBody.accept(this);
        return null;
    }

    @Override
    public Type visit(Print n) {
        n.expression.accept(this);
        return null;
    }

    @Override
    public Type visit(Assign n) {
        n.lValue.accept(this);
        n.rValue.accept(this);
        return null;
    }

    @Override
    public Type visit(ArrayAssign n) {
        n.arrayName.accept(this);
        n.indexVal.accept(this);
        n.rValue.accept(this);
        return null;
    }

    @Override
    public Type visit(And n) {
        n.left.accept(this);
        n.right.accept(this);
        return null;
    }

    @Override
    public Type visit(LessThan n) {
        n.left.accept(this);
        n.right.accept(this);
        return null;
    }

    @Override
    public Type visit(Plus n) {
        n.left.accept(this);
        n.right.accept(this);
        return null;
    }

    @Override
    public Type visit(Minus n) {
        n.left.accept(this);
        n.right.accept(this);
        return null;
    }

    @Override
    public Type visit(Times n) {
        n.left.accept(this);
        n.right.accept(this);
        return null;
    }

    @Override
    public Type visit(Div n) {
        n.left.accept(this);
        n.right.accept(this);
        return null;
    }

    @Override
    public Type visit(ArrayLookup n) {
        n.arrayExp.accept(this);
        n.indexExp.accept(this);
        return null;
    }

    @Override
    public Type visit(ArrayLength n) {
        n.arrayExp.accept(this);
        return null;
    }

    @Override
    public Type visit(Call n) {
        n.object.accept(this);
        n.methodName.accept(this);
        for ( int i = 0; i < n.argsExp.size(); i++ ) {
            n.argsExp.elementAt(i).accept(this);
        }
        return null;
    }

    @Override
    public Type visit(IntegerLiteral n) {
        return null;
    }

    @Override
    public Type visit(True n) {
        return null;
    }

    @Override
    public Type visit(False n) {
        return null;
    }

    @Override
    public Type visit(IdentifierExp n) {
        return null;
    }

    @Override
    public Type visit(This n) {
        return null;
    }

    @Override
    public Type visit(NewArray n) {
        n.arraySize.accept(this);
        return null;
    }

    @Override
    public Type visit(NewObject n) {
        return null;
    }

    @Override
    public Type visit(Not n) {
        return null;
    }

    @Override
    public Type visit(Identifier n) {
        return null;
    }
    
}
