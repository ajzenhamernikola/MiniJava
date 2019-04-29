package poglavlje05.syntaxtree.statement;

import poglavlje05.syntaxtree.visitor.Visitor;

public abstract class Statement {
    public abstract void accept(Visitor v);
}
