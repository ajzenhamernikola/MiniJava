package poglavlje05.syntaxtree.expression;

import poglavlje05.syntaxtree.visitor.Visitor;

public class True extends Exp {
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
