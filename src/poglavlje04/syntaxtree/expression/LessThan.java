package poglavlje04.syntaxtree.expression;

public class LessThan extends Exp {
    Exp left;
    Exp right;

    public LessThan(Exp left, Exp right) {
        this.left = left;
        this.right = right;
    }
}
