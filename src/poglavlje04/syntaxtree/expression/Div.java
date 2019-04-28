package poglavlje04.syntaxtree.expression;

public class Div extends Exp {
    Exp left;
    Exp right;

    public Div(Exp left, Exp right) {
        this.left = left;
        this.right = right;
    }
}
