package poglavlje04.syntaxtree.expression;

public class ArrayLookup extends Exp {
    public Exp arrayExp;
    public Exp indexExp;

    public ArrayLookup(Exp arrayExp, Exp indexExp) {
        this.arrayExp = arrayExp;
        this.indexExp = indexExp;
    }
}
