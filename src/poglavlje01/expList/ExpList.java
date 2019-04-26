package poglavlje01.expList;

import poglavlje01.tables.IntAndTable;
import poglavlje01.tables.Table;

public abstract class ExpList {
    public abstract int maxargs();
    public abstract IntAndTable interpExp(Table t) throws Exception;
}
