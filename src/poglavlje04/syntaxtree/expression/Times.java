package poglavlje04.syntaxtree.expression;

public class Times extends Exp {
    Exp left;
    Exp right;

    public Times(Exp left, Exp right) {
        this.left = left;
        this.right = right;
    }
}
