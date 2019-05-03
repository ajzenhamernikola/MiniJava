package poglavlje06.syntaxtree.type;

import poglavlje06.visitor.TypeVisitor;
import poglavlje06.visitor.Visitor;

public class IdentifierType extends Type {
    public String identifier;

    public IdentifierType(String identifier) {
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
