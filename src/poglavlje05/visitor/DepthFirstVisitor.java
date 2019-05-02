package poglavlje05.visitor;

import poglavlje05.syntaxtree.Identifier;
import poglavlje05.syntaxtree.MainClass;
import poglavlje05.syntaxtree.Program;
import poglavlje05.syntaxtree.classdecl.ClassDeclExtends;
import poglavlje05.syntaxtree.classdecl.ClassDeclSimple;
import poglavlje05.syntaxtree.expression.*;
import poglavlje05.syntaxtree.formal.Formal;
import poglavlje05.syntaxtree.methoddecl.MethodDecl;
import poglavlje05.syntaxtree.statement.*;
import poglavlje05.syntaxtree.type.*;
import poglavlje05.syntaxtree.vardecl.VarDecl;

public class DepthFirstVisitor implements Visitor {

    @Override
    public void visit(Program n) {
        n.mainClass.accept(this);
        for ( int i = 0; i < n.classDeclList.size(); i++ ) {
            n.classDeclList.elementAt(i).accept(this);
        }
    }

    @Override
    public void visit(MainClass n) {
        n.className.accept(this);
        n.argsName.accept(this);
        n.statement.accept(this);
    }

    @Override
    public void visit(ClassDeclSimple n) {
        n.className.accept(this);
        for ( int i = 0; i < n.varDeclList.size(); i++ ) {
            n.varDeclList.elementAt(i).accept(this);
        }
        for ( int i = 0; i < n.methodDeclList.size(); i++ ) {
            n.methodDeclList.elementAt(i).accept(this);
        }
    }

    @Override
    public void visit(ClassDeclExtends n) {
        n.className.accept(this);
        n.superClassName.accept(this);
        for ( int i = 0; i < n.varDeclList.size(); i++ ) {
            n.varDeclList.elementAt(i).accept(this);
        }
        for ( int i = 0; i < n.methodDeclList.size(); i++ ) {
            n.methodDeclList.elementAt(i).accept(this);
        }
    }

    @Override
    public void visit(VarDecl n) {
        n.varType.accept(this);
        n.varId.accept(this);
    }

    @Override
    public void visit(MethodDecl n) {
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
    }

    @Override
    public void visit(Formal n) {
        n.argType.accept(this);
        n.argId.accept(this);
    }

    @Override
    public void visit(IntArrayType n) {
    }

    @Override
    public void visit(BooleanType n) {
    }

    @Override
    public void visit(IntType n) {
    }

    @Override
    public void visit(IdentifierType n) {
    }

    @Override
    public void visit(Block n) {
        for (int i = 0; i < n.statementList.size(); i++) {
            n.statementList.elementAt(i).accept(this);
        }
    }

    @Override
    public void visit(If n) {
        n.condition.accept(this);
        n.trueStatement.accept(this);
        n.falseStatement.accept(this);
    }

    @Override
    public void visit(While n) {
        n.condition.accept(this);
        n.loopBody.accept(this);
    }

    @Override
    public void visit(Print n) {
        n.expression.accept(this);
    }

    @Override
    public void visit(Assign n) {
        n.lValue.accept(this);
        n.rValue.accept(this);
    }

    @Override
    public void visit(ArrayAssign n) {
        n.arrayName.accept(this);
        n.indexVal.accept(this);
        n.rValue.accept(this);
    }

    @Override
    public void visit(And n) {
        n.left.accept(this);
        n.right.accept(this);
    }

    @Override
    public void visit(LessThan n) {
        n.left.accept(this);
        n.right.accept(this);
    }

    @Override
    public void visit(Plus n) {
        n.left.accept(this);
        n.right.accept(this);
    }

    @Override
    public void visit(Minus n) {
        n.left.accept(this);
        n.right.accept(this);
    }

    @Override
    public void visit(Times n) {
        n.left.accept(this);
        n.right.accept(this);
    }

    @Override
    public void visit(Div n) {
        n.left.accept(this);
        n.right.accept(this);
    }

    @Override
    public void visit(ArrayLookup n) {
        n.arrayExp.accept(this);
        n.indexExp.accept(this);
    }

    @Override
    public void visit(ArrayLength n) {
        n.arrayExp.accept(this);
    }

    @Override
    public void visit(Call n) {
        n.object.accept(this);
        n.methodName.accept(this);
        for ( int i = 0; i < n.argsExp.size(); i++ ) {
            n.argsExp.elementAt(i).accept(this);
        }
    }

    @Override
    public void visit(IntegerLiteral n) {
    }

    @Override
    public void visit(True n) {
    }

    @Override
    public void visit(False n) {
    }

    @Override
    public void visit(IdentifierExp n) {
    }

    @Override
    public void visit(This n) {
    }

    @Override
    public void visit(NewArray n) {
        n.arraySize.accept(this);
    }

    @Override
    public void visit(NewObject n) {
    }

    @Override
    public void visit(Not n) {
    }

    @Override
    public void visit(Identifier n) {
    }

}
