package poglavlje01.stm;

import poglavlje01.tables.Table;

public class CompoundStm extends Stm {
    public Stm stm1;
    public Stm stm2;

    public CompoundStm(Stm stm1, Stm stm2) {
        this.stm1 = stm1;
        this.stm2 = stm2;
    }

    @Override
    public int maxargs() {
        int max1 = stm1.maxargs();
        int max2 = stm2.maxargs();
        return max1 > max2 ? max1 : max2;
    }

    @Override
    public Table interpStm(Table t) throws Exception {
        Table interpretedStmt1Table = stm1.interpStm(t);
        return stm2.interpStm(interpretedStmt1Table);
    }
}
