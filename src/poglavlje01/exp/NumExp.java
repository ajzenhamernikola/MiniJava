package poglavlje01.exp;

import poglavlje01.tables.IntAndTable;
import poglavlje01.tables.Table;

public class NumExp extends Exp {
    public int num;

    public NumExp(int num) {
        this.num = num;
    }

    @Override
    public int maxargs() {
        return 1;
    }

    @Override
    public IntAndTable interpExp(Table t) {
        return new IntAndTable(this.num, t);
    }
}
