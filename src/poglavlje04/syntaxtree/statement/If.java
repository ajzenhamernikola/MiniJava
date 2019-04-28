package poglavlje04.syntaxtree.statement;

import poglavlje04.syntaxtree.expression.Exp;

public class If extends Statement {
    Exp condition;
    Statement trueStatement;
    Statement falseStatement;

    public If(Exp condition, Statement trueStatement, Statement falseStatement) {
        this.condition = condition;
        this.trueStatement = trueStatement;
        this.falseStatement = falseStatement;
    }
}
