package poglavlje05.syntaxtree.statement;

import poglavlje05.syntaxtree.visitor.Visitor;

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
