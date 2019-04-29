package poglavlje05.syntaxtree.type;

import poglavlje05.syntaxtree.visitor.Visitor;

public class IdentifierType extends Type {
    public String identifier;

    public IdentifierType(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
