package poglavlje04.syntaxtree;

import poglavlje04.syntaxtree.statement.Statement;
import poglavlje04.syntaxtree.visitor.Visitor;

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
}
