package poglavlje05.syntaxtree.type;

import poglavlje05.visitor.TypeVisitor;
import poglavlje05.visitor.Visitor;

public abstract class Type {
    public abstract void accept(Visitor v);
    public abstract Type accept(TypeVisitor v);
}
