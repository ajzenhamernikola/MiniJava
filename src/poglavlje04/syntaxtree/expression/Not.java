package poglavlje04.syntaxtree.expression;

public class Not extends Exp {
    Exp value;

    public Not(Exp value) {
        this.value = value;
    }
}
