package poglavlje06.syntaxtree.classdecl;

import poglavlje06.syntaxtree.Identifier;
import poglavlje06.syntaxtree.methoddecl.MethodDeclList;
import poglavlje06.syntaxtree.type.Type;
import poglavlje06.syntaxtree.vardecl.VarDeclList;
import poglavlje06.visitor.TypeVisitor;
import poglavlje06.visitor.Visitor;

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

    @Override
    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}
