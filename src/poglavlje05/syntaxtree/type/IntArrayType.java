package poglavlje05.syntaxtree.type;

import poglavlje05.visitor.TypeVisitor;
import poglavlje05.visitor.Visitor;

public class IntArrayType extends Type {
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}
