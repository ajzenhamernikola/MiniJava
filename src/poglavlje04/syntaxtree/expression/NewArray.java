package poglavlje04.syntaxtree.expression;

import poglavlje04.syntaxtree.visitor.Visitor;

public class NewArray extends Exp {
    public Exp arraySize;

    public NewArray(Exp arraySize) {
        this.arraySize = arraySize;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
