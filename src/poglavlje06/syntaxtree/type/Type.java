package poglavlje06.syntaxtree.type;

import poglavlje06.visitor.TypeVisitor;
import poglavlje06.visitor.Visitor;

public abstract class Type {
    public abstract void accept(Visitor v);
    public abstract Type accept(TypeVisitor v);
}
