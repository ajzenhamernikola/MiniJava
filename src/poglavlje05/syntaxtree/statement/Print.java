package poglavlje05.syntaxtree.statement;

import poglavlje05.syntaxtree.expression.Exp;
import poglavlje05.syntaxtree.type.Type;
import poglavlje05.visitor.TypeVisitor;
import poglavlje05.visitor.Visitor;

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
