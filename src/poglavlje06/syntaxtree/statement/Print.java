package poglavlje06.syntaxtree.statement;

import poglavlje06.syntaxtree.expression.Exp;
import poglavlje06.syntaxtree.type.Type;
import poglavlje06.visitor.TypeVisitor;
import poglavlje06.visitor.Visitor;

public class Print extends Statement {
    public Exp expression;

    public Print(Exp expression) {
        this.expression = expression;
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
