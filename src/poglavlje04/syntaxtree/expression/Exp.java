package poglavlje04.syntaxtree.expression;

import poglavlje04.syntaxtree.visitor.Visitor;

public abstract class Exp {
    public abstract void accept(Visitor v);
}
