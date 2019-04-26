package poglavlje01.exp;

import poglavlje01.binop.Binop;
import poglavlje01.tables.IntAndTable;
import poglavlje01.tables.Table;

public class OpExp extends Exp {
    public Exp exp1;
    public Exp exp2;
    public Binop binop;

    public OpExp(Exp exp1, Binop binop, Exp exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.binop = binop;
    }

    @Override
    public int maxargs() {
        return 1;
    }

    @Override
    public IntAndTable interpExp(Table t) throws Exception {
        IntAndTable t1 = exp1.interpExp(t);
        IntAndTable t2 = exp2.interpExp(t1.t);
        int result;

        if (Binop.Op.Plus == this.binop.op) {
            result = t1.i + t2.i;
        }
        else if (Binop.Op.Minus == this.binop.op) {
            result = t1.i - t2.i;
        }
        else if (Binop.Op.Times == this.binop.op) {
            result = t1.i * t2.i;
        }
        else if (Binop.Op.Div == this.binop.op) {
            result = t1.i / t2.i;
        }
        else {
            throw new Exception("Not supported operand");
        }

        return new IntAndTable(result, t2.t);
    }
}
