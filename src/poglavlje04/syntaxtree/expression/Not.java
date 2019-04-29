package poglavlje04.syntaxtree.expression;

import poglavlje04.syntaxtree.visitor.Visitor;

public class Not extends Exp {
    public Exp value;

    public Not(Exp value) {
        this.value = value;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
