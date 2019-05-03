package poglavlje06.syntaxtree.expression;

import poglavlje06.syntaxtree.type.Type;
import poglavlje06.visitor.TypeVisitor;
import poglavlje06.visitor.Visitor;

public class False extends Exp {
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}
