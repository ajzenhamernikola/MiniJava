package poglavlje05.syntaxtree.statement;

import poglavlje05.syntaxtree.expression.Exp;
import poglavlje05.syntaxtree.visitor.Visitor;

public class Print extends Statement {
    public Exp expression;

    public Print(Exp expression) {
        this.expression = expression;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
