package poglavlje04.syntaxtree.type;

import poglavlje04.syntaxtree.visitor.Visitor;

public class BooleanType extends Type {
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
