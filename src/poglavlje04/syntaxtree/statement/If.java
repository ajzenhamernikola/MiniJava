package poglavlje04.syntaxtree.statement;

import poglavlje04.syntaxtree.expression.Exp;
import poglavlje04.syntaxtree.visitor.Visitor;

public class If extends Statement {
    public Exp condition;
    public Statement trueStatement;
    public Statement falseStatement;

    public If(Exp condition, Statement trueStatement, Statement falseStatement) {
        this.condition = condition;
        this.trueStatement = trueStatement;
        this.falseStatement = falseStatement;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
