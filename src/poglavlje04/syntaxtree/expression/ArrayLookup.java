package poglavlje04.syntaxtree.expression;

public class ArrayLookup extends Exp {
    Exp arrayExp;
    Exp indexExp;

    public ArrayLookup(Exp arrayExp, Exp indexExp) {
        this.arrayExp = arrayExp;
        this.indexExp = indexExp;
    }
}
