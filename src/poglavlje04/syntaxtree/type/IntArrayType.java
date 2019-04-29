package poglavlje04.syntaxtree.type;

import poglavlje04.syntaxtree.visitor.Visitor;

public class IntArrayType extends Type {
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
