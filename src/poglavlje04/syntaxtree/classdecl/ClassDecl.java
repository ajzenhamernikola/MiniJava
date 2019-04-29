package poglavlje04.syntaxtree.classdecl;

import poglavlje04.syntaxtree.visitor.Visitor;

public abstract class ClassDecl {
    public abstract void accept(Visitor v);
}
