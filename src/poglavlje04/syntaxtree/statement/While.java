package poglavlje04.syntaxtree.statement;

import poglavlje04.syntaxtree.expression.Exp;
import poglavlje04.syntaxtree.visitor.Visitor;

public class While extends Statement {
    public Exp condition;
    public Statement loopBody;

    public While(Exp condition, Statement loopBody) {
        this.condition = condition;
        this.loopBody = loopBody;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
