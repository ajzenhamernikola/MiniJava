package poglavlje05.syntaxtree.expression;

import poglavlje05.syntaxtree.visitor.Visitor;

public class ArrayLookup extends Exp {
    public Exp arrayExp;
    public Exp indexExp;

    public ArrayLookup(Exp arrayExp, Exp indexExp) {
        this.arrayExp = arrayExp;
        this.indexExp = indexExp;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
