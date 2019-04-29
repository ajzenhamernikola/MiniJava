package poglavlje05.syntaxtree.statement;

import poglavlje05.syntaxtree.expression.Exp;
import poglavlje05.syntaxtree.type.Type;
import poglavlje05.syntaxtree.visitor.TypeVisitor;
import poglavlje05.syntaxtree.visitor.Visitor;

public class While extends Statement {
    public Exp condition;
    public Statement loopBody;

    public While(Exp condition, Statement loopBody) {
        this.condition = condition;
        this.loopBody = loopBody;
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
