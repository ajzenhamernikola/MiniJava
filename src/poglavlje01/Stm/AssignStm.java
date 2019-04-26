package poglavlje01.Stm;

import poglavlje01.Exp.Exp;

public class AssignStm extends Stm {
    public String id;
    public Exp exp;

    public AssignStm(String id, Exp exp) {
        this.id = id;
        this.exp = exp;
    }

    @Override
    public int maxargs() {
        return exp.maxargs();
    }
}
