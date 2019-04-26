package poglavlje01.stm;

import poglavlje01.tables.Table;

public abstract class Stm {
    public abstract int maxargs();
    public abstract Table interpStm(Table t) throws Exception;
}
