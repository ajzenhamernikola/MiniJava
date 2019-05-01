package poglavlje05.syntaxtree.formal;

import poglavlje05.syntaxtree.Identifier;
import poglavlje05.syntaxtree.type.Type;
import poglavlje05.visitor.TypeVisitor;
import poglavlje05.visitor.Visitor;

public class Formal {
    public Type argType;
    public Identifier argId;

    public Formal(Type argType, Identifier argId) {
        this.argType = argType;
        this.argId = argId;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}
