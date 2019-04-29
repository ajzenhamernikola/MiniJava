package poglavlje04.syntaxtree.expression;

public class And extends Exp {
    public Exp left;
    public Exp right;

    public And(Exp left, Exp right) {
        this.left = left;
        this.right = right;
    }
}
