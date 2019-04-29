package poglavlje05.syntaxtree;

import poglavlje05.syntaxtree.visitor.Visitor;

public class Identifier {
    public String identifier;

    public Identifier(String identifier) {
        this.identifier = identifier;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
