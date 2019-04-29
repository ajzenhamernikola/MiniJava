package poglavlje04.syntaxtree.expression;

public class NewArray extends Exp {
    public Exp arraySize;

    public NewArray(Exp arraySize) {
        this.arraySize = arraySize;
    }
}
