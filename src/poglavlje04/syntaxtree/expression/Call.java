package poglavlje04.syntaxtree.expression;

import poglavlje04.syntaxtree.Identifier;
import poglavlje04.syntaxtree.visitor.Visitor;

public class Call extends Exp {
    public Exp object;
    public Identifier methodName;
    public ExpList argsExp;

    public Call(Exp object, Identifier methodName, ExpList argsExp) {
        this.object = object;
        this.methodName = methodName;
        this.argsExp = argsExp;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
