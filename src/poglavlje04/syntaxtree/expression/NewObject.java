package poglavlje04.syntaxtree.expression;

import poglavlje04.syntaxtree.Identifier;
import poglavlje04.syntaxtree.visitor.Visitor;

public class NewObject extends Exp {
    public Identifier className;

    public NewObject(Identifier className) {
        this.className = className;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
