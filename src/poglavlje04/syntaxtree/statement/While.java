package poglavlje04.syntaxtree.statement;

import poglavlje04.syntaxtree.expression.Exp;

public class While extends Statement {
    Exp condition;
    Statement loopBody;

    public While(Exp condition, Statement loopBody) {
        this.condition = condition;
        this.loopBody = loopBody;
    }
}
