package poglavlje04.syntaxtree.classdecl;

import poglavlje04.syntaxtree.Identifier;
import poglavlje04.syntaxtree.methoddecl.MethodDeclList;
import poglavlje04.syntaxtree.vardecl.VarDeclList;

public class ClassDeclSimple extends ClassDecl {
    public Identifier className;
    public VarDeclList varDeclList;
    public MethodDeclList methodDeclList;

    public ClassDeclSimple(Identifier className, VarDeclList varDeclList, MethodDeclList methodDeclList) {
        this.className = className;
        this.varDeclList = varDeclList;
        this.methodDeclList = methodDeclList;
    }
}
