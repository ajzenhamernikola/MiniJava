package poglavlje05.syntaxtree.classdecl;

import poglavlje05.syntaxtree.visitor.Visitor;

public abstract class ClassDecl {
    public abstract void accept(Visitor v);
}
