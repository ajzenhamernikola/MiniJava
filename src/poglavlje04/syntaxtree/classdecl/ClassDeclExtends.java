package poglavlje04.syntaxtree.classdecl;

import poglavlje04.syntaxtree.Identifier;
import poglavlje04.syntaxtree.methoddecl.MethodDeclList;
import poglavlje04.syntaxtree.vardecl.VarDeclList;

public class ClassDeclExtends extends ClassDecl {
    Identifier className;
    Identifier superClassName;
    VarDeclList varDeclList;
    MethodDeclList methodDeclList;

    public ClassDeclExtends(Identifier className, Identifier superClassName, VarDeclList varDeclList, MethodDeclList methodDeclList) {
        this.className = className;
        this.superClassName = superClassName;
        this.varDeclList = varDeclList;
        this.methodDeclList = methodDeclList;
    }
}
