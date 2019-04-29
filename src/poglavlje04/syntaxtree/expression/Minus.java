package poglavlje04.syntaxtree.expression;

public class Minus extends Exp {
    public Exp left;
    public Exp right;

    public Minus(Exp left, Exp right) {
        this.left = left;
        this.right = right;
    }
}
