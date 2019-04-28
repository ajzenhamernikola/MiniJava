package poglavlje04.syntaxtree.statement;

import poglavlje04.syntaxtree.Identifier;
import poglavlje04.syntaxtree.expression.Exp;

public class ArrayAssign extends Statement {
    Identifier arrayName;
    Exp indexVal;
    Exp rValue;

    public ArrayAssign(Identifier arrayName, Exp indexVal, Exp rValue) {
        this.arrayName = arrayName;
        this.indexVal = indexVal;
        this.rValue = rValue;
    }
}
