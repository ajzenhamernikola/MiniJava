package poglavlje01.exp;

import poglavlje01.stm.Stm;

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
}
