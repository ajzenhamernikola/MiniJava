package poglavlje05.syntaxtree.methoddecl;

import poglavlje05.syntaxtree.Identifier;
import poglavlje05.syntaxtree.expression.Exp;
import poglavlje05.syntaxtree.formal.FormalList;
import poglavlje05.syntaxtree.statement.StatementList;
import poglavlje05.syntaxtree.type.Type;
import poglavlje05.syntaxtree.vardecl.VarDeclList;
import poglavlje05.syntaxtree.visitor.TypeVisitor;
import poglavlje05.syntaxtree.visitor.Visitor;

public class MethodDecl {
    public Type returnType;
    public Identifier methodName;
    public FormalList argsList;
    public VarDeclList varDeclList;
    public StatementList statementList;
    public Exp returnValue;

    public MethodDecl(Type returnType, Identifier methodName, FormalList argsList, VarDeclList varDeclList, StatementList statementList, Exp returnValue) {
        this.returnType = returnType;
        this.methodName = methodName;
        this.argsList = argsList;
        this.varDeclList = varDeclList;
        this.statementList = statementList;
        this.returnValue = returnValue;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}
