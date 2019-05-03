package poglavlje06.symboltable;

import poglavlje06.syntaxtree.type.Type;

public class Variable {
    Symbol id;
    Type type;

    public Variable(Symbol id, Type type) {
        this.id = id;
        this.type = type;
    }

    public Symbol id() {
        return id;
    }

    public Type type() {
        return type;
    }
}
