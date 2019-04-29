package poglavlje04.syntaxtree.statement;

import poglavlje04.syntaxtree.visitor.Visitor;

public class Block extends Statement {
    public StatementList statementList;

    public Block(StatementList statementList) {
        this.statementList = statementList;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
