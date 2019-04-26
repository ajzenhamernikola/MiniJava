package poglavlje01.Exp;

import poglavlje01.Stm.Stm;

public class EseqExp extends Exp {
    public Stm stm;
    public Exp exp;

    public EseqExp(Stm stm, Exp exp) {
        this.stm = stm;
        this.exp = exp;
    }
}
