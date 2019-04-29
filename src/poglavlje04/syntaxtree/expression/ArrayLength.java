package poglavlje04.syntaxtree.expression;

import poglavlje04.syntaxtree.visitor.Visitor;

public class ArrayLength extends Exp {
    public Exp arrayExp;

    public ArrayLength(Exp arrayExp) {
        this.arrayExp = arrayExp;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
