package poglavlje05.syntaxtree;

import poglavlje05.syntaxtree.statement.Statement;
import poglavlje05.syntaxtree.type.Type;
import poglavlje05.syntaxtree.visitor.TypeVisitor;
import poglavlje05.syntaxtree.visitor.Visitor;

public class MainClass {
    public Identifier className;
    public Identifier argsName;
    public Statement statement;

    public MainClass(Identifier className, Identifier argsName, Statement statement) {
        this.className = className;
        this.argsName = argsName;
        this.statement = statement;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}
