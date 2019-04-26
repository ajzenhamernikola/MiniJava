package poglavlje01.ExpList;

import poglavlje01.Exp.Exp;

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
}
