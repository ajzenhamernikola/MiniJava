package poglavlje04.syntaxtree.expression;

import poglavlje04.syntaxtree.Identifier;

public class NewObject extends Exp {
    Identifier className;

    public NewObject(Identifier className) {
        this.className = className;
    }
}
