package poglavlje04.syntaxtree.statement;

import poglavlje04.syntaxtree.expression.Exp;
import poglavlje04.syntaxtree.visitor.Visitor;

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
