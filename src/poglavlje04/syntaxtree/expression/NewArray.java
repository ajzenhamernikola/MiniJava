package poglavlje04.syntaxtree.expression;

public class NewArray extends Exp {
    Exp arraySize;

    public NewArray(Exp arraySize) {
        this.arraySize = arraySize;
    }
}
