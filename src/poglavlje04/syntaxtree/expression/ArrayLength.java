package poglavlje04.syntaxtree.expression;

public class ArrayLength extends Exp {
    public Exp arrayExp;

    public ArrayLength(Exp arrayExp) {
        this.arrayExp = arrayExp;
    }
}
