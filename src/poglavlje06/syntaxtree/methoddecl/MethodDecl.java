package poglavlje06.syntaxtree.methoddecl;

import poglavlje06.syntaxtree.Identifier;
import poglavlje06.syntaxtree.expression.Exp;
import poglavlje06.syntaxtree.formal.FormalList;
import poglavlje06.syntaxtree.statement.StatementList;
import poglavlje06.syntaxtree.type.Type;
import poglavlje06.syntaxtree.vardecl.VarDeclList;
import poglavlje06.visitor.TypeVisitor;
import poglavlje06.visitor.Visitor;

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
