package poglavlje05.syntaxtree.statement;

import poglavlje05.syntaxtree.Identifier;
import poglavlje05.syntaxtree.expression.Exp;
import poglavlje05.syntaxtree.type.Type;
import poglavlje05.visitor.TypeVisitor;
import poglavlje05.visitor.Visitor;

public class ArrayAssign extends Statement {
    public Identifier arrayName;
    public Exp indexVal;
    public Exp rValue;

    public ArrayAssign(Identifier arrayName, Exp indexVal, Exp rValue) {
        this.arrayName = arrayName;
        this.indexVal = indexVal;
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
