package poglavlje01.expList;

import poglavlje01.exp.Exp;
import poglavlje01.tables.IntAndTable;
import poglavlje01.tables.Table;

public class LastExpList extends ExpList {
    public Exp exp;

    public LastExpList(Exp exp) {
        this.exp = exp;
    }

    @Override
    public int maxargs() {
        return exp.maxargs();
    }

    @Override
    public IntAndTable interpExp(Table t) throws Exception {
        IntAndTable interpTable = exp.interpExp(t);
        System.out.print(interpTable.i + " ");

        return interpTable;
    }
}
