package poglavlje05.syntaxtree.expression;

import poglavlje05.syntaxtree.Identifier;
import poglavlje05.syntaxtree.visitor.Visitor;

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
