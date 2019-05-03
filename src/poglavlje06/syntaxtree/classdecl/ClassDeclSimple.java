package poglavlje06.syntaxtree.classdecl;

import poglavlje06.syntaxtree.Identifier;
import poglavlje06.syntaxtree.methoddecl.MethodDeclList;
import poglavlje06.syntaxtree.type.Type;
import poglavlje06.syntaxtree.vardecl.VarDeclList;
import poglavlje06.visitor.TypeVisitor;
import poglavlje06.visitor.Visitor;

public class ClassDeclSimple extends ClassDecl {
    public Identifier className;
    public VarDeclList varDeclList;
    public MethodDeclList methodDeclList;

    public ClassDeclSimple(Identifier className, VarDeclList varDeclList, MethodDeclList methodDeclList) {
        this.className = className;
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
