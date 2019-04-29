package poglavlje04.syntaxtree.expression;

public class Plus extends Exp {
    public Exp left;
    public Exp right;

    public Plus(Exp left, Exp right) {
        this.left = left;
        this.right = right;
    }
}
