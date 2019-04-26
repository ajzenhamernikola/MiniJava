package poglavlje01.exp;

import poglavlje01.tables.IntAndTable;
import poglavlje01.tables.Table;

public abstract class Exp {
    public abstract int maxargs();
    public abstract IntAndTable interpExp(Table t) throws Exception;
}
