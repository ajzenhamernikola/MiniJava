package poglavlje04.syntaxtree.expression;

import poglavlje04.syntaxtree.visitor.Visitor;

public class This extends Exp {
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
