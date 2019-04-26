package poglavlje01.expList;

import poglavlje01.exp.Exp;

public class LastExpList extends ExpList {
    public Exp exp;

    public LastExpList(Exp exp) {
        this.exp = exp;
    }

    @Override
    public int maxargs() {
        return exp.maxargs();
    }
}
