package poglavlje05.syntaxtree.expression;

import poglavlje05.syntaxtree.visitor.Visitor;

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
