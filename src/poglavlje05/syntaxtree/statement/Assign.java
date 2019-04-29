package poglavlje05.syntaxtree.statement;

import poglavlje05.syntaxtree.Identifier;
import poglavlje05.syntaxtree.expression.Exp;
import poglavlje05.syntaxtree.visitor.Visitor;

public class Assign extends Statement {
    public Identifier lValue;
    public Exp rValue;

    public Assign(Identifier lValue, Exp rValue) {
        this.lValue = lValue;
        this.rValue = rValue;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
