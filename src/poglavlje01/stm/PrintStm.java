package poglavlje01.stm;

import poglavlje01.expList.ExpList;
import poglavlje01.tables.IntAndTable;
import poglavlje01.tables.Table;

public class PrintStm extends Stm {
    public ExpList list;

    public PrintStm(ExpList list) {
        this.list = list;
    }

    @Override
    public int maxargs() {
        return list.maxargs();
    }

    @Override
    public Table interpStm(Table t) throws Exception {
        IntAndTable interpretedTable = list.interpExp(t);
        System.out.println();
        return interpretedTable.t;
    }
}
