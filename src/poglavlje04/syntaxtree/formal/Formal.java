package poglavlje04.syntaxtree.formal;

import poglavlje04.syntaxtree.Identifier;
import poglavlje04.syntaxtree.type.Type;
import poglavlje04.syntaxtree.visitor.Visitor;

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
}
