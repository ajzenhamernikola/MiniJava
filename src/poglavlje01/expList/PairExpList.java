package poglavlje01.expList;

import poglavlje01.exp.Exp;
import poglavlje01.tables.IntAndTable;
import poglavlje01.tables.Table;

public class PairExpList extends ExpList {
    public Exp head;
    public ExpList tail;

    public PairExpList(Exp head, ExpList tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public int maxargs() {
        return head.maxargs() + tail.maxargs();
    }

    @Override
    public IntAndTable interpExp(Table t) throws Exception {
        IntAndTable headTable = head.interpExp(t);
        System.out.print(headTable.i + " ");
        return tail.interpExp(headTable.t);
    }
}
