package poglavlje04.syntaxtree.expression;

public class Div extends Exp {
    public Exp left;
    public Exp right;

    public Div(Exp left, Exp right) {
        this.left = left;
        this.right = right;
    }
}
