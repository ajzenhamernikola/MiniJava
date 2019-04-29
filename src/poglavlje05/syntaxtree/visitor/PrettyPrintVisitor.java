package poglavlje05.syntaxtree.visitor;

import poglavlje05.syntaxtree.*;
import poglavlje05.syntaxtree.classdecl.*;
import poglavlje05.syntaxtree.expression.*;
import poglavlje05.syntaxtree.formal.*;
import poglavlje05.syntaxtree.methoddecl.*;
import poglavlje05.syntaxtree.statement.*;
import poglavlje05.syntaxtree.type.*;
import poglavlje05.syntaxtree.vardecl.*;

public class PrettyPrintVisitor implements Visitor {

    @Override
    public void visit(Program n) {
        n.mainClass.accept(this);
        for ( int i = 0; i < n.classDeclList.size(); i++ ) {
            System.out.println();
            n.classDeclList.elementAt(i).accept(this);
        }
    }

    @Override
    public void visit(MainClass n) {
        System.out.print("class ");
        n.className.accept(this);
        System.out.println(" {");
        System.out.print("  public static void main (String [] ");
        n.argsName.accept(this);
        System.out.println(") {");
        System.out.print("    ");
        n.statement.accept(this);
        System.out.println();
        System.out.println("  }");
        System.out.println("}");
    }

    @Override
    public void visit(ClassDeclSimple n) {
        System.out.print("class ");
        n.className.accept(this);
        System.out.println(" { ");
        for ( int i = 0; i < n.varDeclList.size(); i++ ) {
            System.out.print("  ");
            n.varDeclList.elementAt(i).accept(this);
            if ( i+1 < n.varDeclList.size() ) { System.out.println(); }
        }
        for ( int i = 0; i < n.methodDeclList.size(); i++ ) {
            System.out.println();
            n.methodDeclList.elementAt(i).accept(this);
        }
        System.out.println();
        System.out.println("}");
    }

    @Override
    public void visit(ClassDeclExtends n) {
        System.out.print("class ");
        n.className.accept(this);
        System.out.println(" extends ");
        n.superClassName.accept(this);
        System.out.println(" { ");
        for ( int i = 0; i < n.varDeclList.size(); i++ ) {
            System.out.print("  ");
            n.varDeclList.elementAt(i).accept(this);
            if ( i+1 < n.varDeclList.size() ) { System.out.println(); }
        }
        for ( int i = 0; i < n.methodDeclList.size(); i++ ) {
            System.out.println();
            n.methodDeclList.elementAt(i).accept(this);
        }
        System.out.println();
        System.out.println("}");
    }

    @Override
    public void visit(VarDecl n) {
        n.varType.accept(this);
        System.out.print(" ");
        n.varId.accept(this);
        System.out.print(";");
    }

    @Override
    public void visit(MethodDecl n) {
        System.out.print("  public ");
        n.returnType.accept(this);
        System.out.print(" ");
        n.methodName.accept(this);
        System.out.print(" (");
        for ( int i = 0; i < n.argsList.size(); i++ ) {
            n.argsList.elementAt(i).accept(this);
            if (i+1 < n.argsList.size()) { System.out.print(", "); }
        }
        System.out.println(") { ");
        for ( int i = 0; i < n.varDeclList.size(); i++ ) {
            System.out.print("    ");
            n.varDeclList.elementAt(i).accept(this);
            System.out.println();
        }
        for ( int i = 0; i < n.statementList.size(); i++ ) {
            System.out.print("    ");
            n.statementList.elementAt(i).accept(this);
            if ( i < n.statementList.size() ) { System.out.println(); }
        }
        System.out.print("    return ");
        n.returnValue.accept(this);
        System.out.println(";");
        System.out.print("  }");
    }

    @Override
    public void visit(Formal n) {
        n.argType.accept(this);
        System.out.print(" ");
        n.argId.accept(this);
    }

    @Override
    public void visit(IntArrayType n) {
        System.out.print("int []");
    }

    @Override
    public void visit(BooleanType n) {
        System.out.print("boolean");
    }

    @Override
    public void visit(IntType n) {
        System.out.print("int");
    }

    @Override
    public void visit(IdentifierType n) {
        System.out.print(n.identifier);
    }

    @Override
    public void visit(Block n) {
        System.out.println("{ ");
        for ( int i = 0; i < n.statementList.size(); i++ ) {
            System.out.print("      ");
            n.statementList.elementAt(i).accept(this);
            System.out.println();
        }
        System.out.print("    } ");
    }

    @Override
    public void visit(If n) {
        System.out.print("if (");
        n.condition.accept(this);
        System.out.print(") ");
        n.trueStatement.accept(this);
        System.out.println();
        System.out.print("    else ");
        n.falseStatement.accept(this);
    }

    @Override
    public void visit(While n) {
        System.out.print("while (");
        n.condition.accept(this);
        System.out.print(") ");
        n.loopBody.accept(this);
    }

    @Override
    public void visit(Print n) {
        System.out.print("System.out.println(");
        n.expression.accept(this);
        System.out.print(");");
    }

    @Override
    public void visit(Assign n) {
        n.lValue.accept(this);
        System.out.print(" = ");
        n.rValue.accept(this);
        System.out.print(";");
    }

    @Override
    public void visit(ArrayAssign n) {
        n.arrayName.accept(this);
        System.out.print("[");
        n.indexVal.accept(this);
        System.out.print("] = ");
        n.rValue.accept(this);
        System.out.print(";");
    }

    @Override
    public void visit(And n) {
        System.out.print("(");
        n.left.accept(this);
        System.out.print(" && ");
        n.right.accept(this);
        System.out.print(")");
    }

    @Override
    public void visit(LessThan n) {
        System.out.print("(");
        n.left.accept(this);
        System.out.print(" < ");
        n.right.accept(this);
        System.out.print(")");
    }

    @Override
    public void visit(Plus n) {
        System.out.print("(");
        n.left.accept(this);
        System.out.print(" + ");
        n.right.accept(this);
        System.out.print(")");
    }

    @Override
    public void visit(Minus n) {
        System.out.print("(");
        n.left.accept(this);
        System.out.print(" - ");
        n.right.accept(this);
        System.out.print(")");
    }

    @Override
    public void visit(Times n) {
        System.out.print("(");
        n.left.accept(this);
        System.out.print(" * ");
        n.right.accept(this);
        System.out.print(")");
    }

    @Override
    public void visit(Div n) {
        System.out.print("(");
        n.left.accept(this);
        System.out.print(" / ");
        n.right.accept(this);
        System.out.println(")");
    }

    @Override
    public void visit(ArrayLookup n) {
        n.arrayExp.accept(this);
        System.out.print("[");
        n.indexExp.accept(this);
        System.out.print("]");
    }

    @Override
    public void visit(ArrayLength n) {
        n.arrayExp.accept(this);
        System.out.print(".length");
    }

    @Override
    public void visit(Call n) {
        n.object.accept(this);
        System.out.print(".");
        n.methodName.accept(this);
        System.out.print("(");
        for ( int i = 0; i < n.argsExp.size(); i++ ) {
            n.argsExp.elementAt(i).accept(this);
            if ( i+1 < n.argsExp.size() ) { System.out.print(", "); }
        }
        System.out.print(")");
    }

    @Override
    public void visit(IntegerLiteral n) {
        System.out.print(n.value);
    }

    @Override
    public void visit(True n) {
        System.out.print("true");
    }

    @Override
    public void visit(False n) {
        System.out.print("false");
    }

    @Override
    public void visit(IdentifierExp n) {
        System.out.print(n.identifier);
    }

    @Override
    public void visit(This n) {
        System.out.print("this");
    }

    @Override
    public void visit(NewArray n) {
        System.out.print("new int [");
        n.arraySize.accept(this);
        System.out.print("]");
    }

    @Override
    public void visit(NewObject n) {
        System.out.print("new ");
        System.out.print(n.className.identifier);
        System.out.print("()");
    }

    @Override
    public void visit(Not n) {
        System.out.print("!");
        n.value.accept(this);
    }

    @Override
    public void visit(Identifier n) {
        System.out.print(n.identifier);
    }
}
