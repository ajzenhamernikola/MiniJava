package poglavlje04.syntaxtree;

import poglavlje04.syntaxtree.visitor.Visitor;

public class Identifier {
    public String identifier;

    public Identifier(String identifier) {
        this.identifier = identifier;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
