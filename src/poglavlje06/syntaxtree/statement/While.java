package poglavlje06.syntaxtree.statement;

import poglavlje06.syntaxtree.expression.Exp;
import poglavlje06.syntaxtree.type.Type;
import poglavlje06.visitor.TypeVisitor;
import poglavlje06.visitor.Visitor;

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
