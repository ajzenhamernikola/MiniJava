package poglavlje06.syntaxtree.statement;

import poglavlje06.syntaxtree.Identifier;
import poglavlje06.syntaxtree.expression.Exp;
import poglavlje06.syntaxtree.type.Type;
import poglavlje06.visitor.TypeVisitor;
import poglavlje06.visitor.Visitor;

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

    @Override
    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}
