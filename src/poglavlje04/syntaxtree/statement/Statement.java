package poglavlje04.syntaxtree.statement;

import poglavlje04.syntaxtree.visitor.Visitor;

public abstract class Statement {
    public abstract void accept(Visitor v);
}
