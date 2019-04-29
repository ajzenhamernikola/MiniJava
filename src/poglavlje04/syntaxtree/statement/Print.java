package poglavlje04.syntaxtree.statement;

import poglavlje04.syntaxtree.expression.Exp;

public class Print extends Statement {
    public Exp expression;

    public Print(Exp expression) {
        this.expression = expression;
    }
}
