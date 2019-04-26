package poglavlje01.Stm;

import poglavlje01.ExpList.ExpList;

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
