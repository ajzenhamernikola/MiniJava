package poglavlje06.syntaxtree.statement;

import poglavlje06.syntaxtree.Identifier;
import poglavlje06.syntaxtree.expression.Exp;
import poglavlje06.syntaxtree.type.Type;
import poglavlje06.visitor.TypeVisitor;
import poglavlje06.visitor.Visitor;

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
