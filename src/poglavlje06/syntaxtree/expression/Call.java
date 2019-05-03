package poglavlje06.syntaxtree.expression;

import poglavlje06.syntaxtree.Identifier;
import poglavlje06.syntaxtree.type.Type;
import poglavlje06.visitor.TypeVisitor;
import poglavlje06.visitor.Visitor;

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
