package poglavlje01.stm;

import poglavlje01.exp.Exp;
import poglavlje01.tables.IntAndTable;
import poglavlje01.tables.Table;

public class AssignStm extends Stm {
    public String id;
    public Exp exp;

    public AssignStm(String id, Exp exp) {
        this.id = id;
        this.exp = exp;
    }

    @Override
    public int maxargs() {
        return exp.maxargs();
    }

    @Override
    public Table interpStm(Table t) throws Exception {
        // Interpret the expression first
        IntAndTable expTableInterp = this.exp.interpExp(t);
        int interpretedValue = expTableInterp.i;
        Table interpretedTable = expTableInterp.t;

        if (null == interpretedTable) {
            return new Table (this.id, interpretedValue, null);
        }

        // The identifier needs to be assigned to the interpreted value.
        // We check for its existence in the table.
        Table tableThatContainsId = interpretedTable.exists(this.id);
        if (null != tableThatContainsId) {
            tableThatContainsId.value = interpretedValue;
            return tableThatContainsId;
        }

        return new Table(this.id, interpretedValue, interpretedTable);
    }
}
