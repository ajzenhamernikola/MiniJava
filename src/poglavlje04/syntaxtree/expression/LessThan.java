package poglavlje04.syntaxtree.expression;

public class LessThan extends Exp {
    public Exp left;
    public Exp right;

    public LessThan(Exp left, Exp right) {
        this.left = left;
        this.right = right;
    }
}
