package poglavlje04.syntaxtree.statement;

public class Block extends Statement {
    public StatementList statementList;

    public Block(StatementList statementList) {
        this.statementList = statementList;
    }
}
