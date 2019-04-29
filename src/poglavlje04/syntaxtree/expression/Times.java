package poglavlje04.syntaxtree.expression;

import poglavlje04.syntaxtree.visitor.Visitor;

public class Times extends Exp {
    public Exp left;
    public Exp right;

    public Times(Exp left, Exp right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
