package poglavlje05.syntaxtree.classdecl;

import poglavlje05.syntaxtree.Identifier;
import poglavlje05.syntaxtree.methoddecl.MethodDeclList;
import poglavlje05.syntaxtree.vardecl.VarDeclList;
import poglavlje05.syntaxtree.visitor.Visitor;

public class ClassDeclExtends extends ClassDecl {
    public Identifier className;
    public Identifier superClassName;
    public VarDeclList varDeclList;
    public MethodDeclList methodDeclList;

    public ClassDeclExtends(Identifier className, Identifier superClassName, VarDeclList varDeclList, MethodDeclList methodDeclList) {
        this.className = className;
        this.superClassName = superClassName;
        this.varDeclList = varDeclList;
        this.methodDeclList = methodDeclList;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
