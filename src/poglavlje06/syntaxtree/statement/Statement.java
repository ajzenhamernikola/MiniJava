package poglavlje06.syntaxtree.statement;

import poglavlje06.syntaxtree.type.Type;
import poglavlje06.visitor.TypeVisitor;
import poglavlje06.visitor.Visitor;

public abstract class Statement {
    public abstract void accept(Visitor v);
    public abstract Type accept(TypeVisitor v);
}
