package poglavlje04.syntaxtree.methoddecl;

import poglavlje04.syntaxtree.Identifier;
import poglavlje04.syntaxtree.expression.Exp;
import poglavlje04.syntaxtree.formal.FormalList;
import poglavlje04.syntaxtree.statement.StatementList;
import poglavlje04.syntaxtree.type.Type;
import poglavlje04.syntaxtree.vardecl.VarDeclList;

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
}
