package poglavlje04.syntaxtree.expression;

public class Not extends Exp {
    public Exp value;

    public Not(Exp value) {
        this.value = value;
    }
}
