package poglavlje05.syntaxtree.statement;

import poglavlje05.syntaxtree.type.Type;
import poglavlje05.syntaxtree.visitor.TypeVisitor;
import poglavlje05.syntaxtree.visitor.Visitor;

public abstract class Statement {
    public abstract void accept(Visitor v);
    public abstract Type accept(TypeVisitor v);
}
