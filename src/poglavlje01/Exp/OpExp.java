package poglavlje01.Exp;

import poglavlje01.Binop.Binop;

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
}
