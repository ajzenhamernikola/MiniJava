package poglavlje04.syntaxtree.type;

import poglavlje04.syntaxtree.visitor.Visitor;

public abstract class Type {
    public abstract void accept(Visitor v);
}
