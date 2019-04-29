package poglavlje05.syntaxtree.classdecl;

import poglavlje05.syntaxtree.type.Type;
import poglavlje05.syntaxtree.visitor.TypeVisitor;
import poglavlje05.syntaxtree.visitor.Visitor;

public abstract class ClassDecl {
    public abstract void accept(Visitor v);
    public abstract Type accept(TypeVisitor v);
}
