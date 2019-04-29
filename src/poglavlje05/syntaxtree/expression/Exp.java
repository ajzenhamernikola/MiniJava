package poglavlje05.syntaxtree.expression;

import poglavlje05.syntaxtree.visitor.Visitor;

public abstract class Exp {
    public abstract void accept(Visitor v);
}
