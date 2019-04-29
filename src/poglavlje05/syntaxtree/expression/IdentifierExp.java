package poglavlje05.syntaxtree.expression;

import poglavlje05.syntaxtree.type.Type;
import poglavlje05.syntaxtree.visitor.TypeVisitor;
import poglavlje05.syntaxtree.visitor.Visitor;

public class IdentifierExp extends Exp {
    public String identifier;

    public IdentifierExp(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}
