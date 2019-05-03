package poglavlje06.syntaxtree.formal;

import poglavlje06.syntaxtree.Identifier;
import poglavlje06.syntaxtree.type.Type;
import poglavlje06.visitor.TypeVisitor;
import poglavlje06.visitor.Visitor;

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
