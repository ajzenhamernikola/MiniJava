package poglavlje05.syntaxtree.expression;

import poglavlje05.syntaxtree.visitor.Visitor;

public class This extends Exp {
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
