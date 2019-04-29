package poglavlje04.syntaxtree.statement;

import poglavlje04.syntaxtree.expression.Exp;

public class While extends Statement {
    public Exp condition;
    public Statement loopBody;

    public While(Exp condition, Statement loopBody) {
        this.condition = condition;
        this.loopBody = loopBody;
    }
}
