package poglavlje05.syntaxtree.type;

import poglavlje05.syntaxtree.visitor.TypeVisitor;
import poglavlje05.syntaxtree.visitor.Visitor;

public abstract class Type {
    public abstract void accept(Visitor v);
    public abstract Type accept(TypeVisitor v);
}
