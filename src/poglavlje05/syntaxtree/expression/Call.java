package poglavlje05.syntaxtree.expression;

import poglavlje05.syntaxtree.Identifier;
import poglavlje05.syntaxtree.type.Type;
import poglavlje05.visitor.TypeVisitor;
import poglavlje05.visitor.Visitor;

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

    @Override
    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}
