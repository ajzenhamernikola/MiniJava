package poglavlje01.exp;

import poglavlje01.stm.Stm;
import poglavlje01.tables.IntAndTable;
import poglavlje01.tables.Table;

public class EseqExp extends Exp {
    public Stm stm;
    public Exp exp;

    public EseqExp(Stm stm, Exp exp) {
        this.stm = stm;
        this.exp = exp;
    }

    @Override
    public int maxargs() {
        int max1 = stm.maxargs();
        int max2 = exp.maxargs();
        return max1 > max2 ? max1 : max2;
    }

    @Override
    public IntAndTable interpExp(Table t) throws Exception {
        Table stmTable = stm.interpStm(t);
        return exp.interpExp(stmTable);
    }
}
