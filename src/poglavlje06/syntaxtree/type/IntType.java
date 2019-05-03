package poglavlje06.syntaxtree.type;

import poglavlje06.visitor.TypeVisitor;
import poglavlje06.visitor.Visitor;

public class IntType extends Type {
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}
