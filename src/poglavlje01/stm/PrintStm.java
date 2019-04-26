package poglavlje01.stm;

import poglavlje01.expList.ExpList;

public class PrintStm extends Stm {
    public ExpList list;

    public PrintStm(ExpList list) {
        this.list = list;
    }

    @Override
    public int maxargs() {
        return list.maxargs();
    }
}
