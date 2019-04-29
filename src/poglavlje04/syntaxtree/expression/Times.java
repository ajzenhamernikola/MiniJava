package poglavlje04.syntaxtree.expression;

public class Times extends Exp {
    public Exp left;
    public Exp right;

    public Times(Exp left, Exp right) {
        this.left = left;
        this.right = right;
    }
}
