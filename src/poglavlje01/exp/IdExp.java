package poglavlje01.exp;

import poglavlje01.tables.IntAndTable;
import poglavlje01.tables.Table;

public class IdExp extends Exp {
    public String id;

    public IdExp(String id) {
        this.id = id;
    }

    @Override
    public int maxargs() {
        return 1;
    }

    @Override
    public IntAndTable interpExp(Table t) throws Exception {
        if (null != t) {
            return new IntAndTable(t.lookup(this.id), t);
        }

        throw new Exception("Cannot interpret id " + this.id + " on an empty table");
    }
}
