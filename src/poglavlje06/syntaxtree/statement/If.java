package poglavlje06.syntaxtree.statement;

import poglavlje06.syntaxtree.expression.Exp;
import poglavlje06.syntaxtree.type.Type;
import poglavlje06.visitor.TypeVisitor;
import poglavlje06.visitor.Visitor;

public class If extends Statement {
    public Exp condition;
    public Statement trueStatement;
    public Statement falseStatement;

    public If(Exp condition, Statement trueStatement, Statement falseStatement) {
        this.condition = condition;
        this.trueStatement = trueStatement;
        this.falseStatement = falseStatement;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}
