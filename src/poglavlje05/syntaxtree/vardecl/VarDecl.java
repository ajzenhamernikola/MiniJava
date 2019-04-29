package poglavlje05.syntaxtree.vardecl;

import poglavlje05.syntaxtree.Identifier;
import poglavlje05.syntaxtree.type.Type;
import poglavlje05.syntaxtree.visitor.TypeVisitor;
import poglavlje05.syntaxtree.visitor.Visitor;

public class VarDecl {
    public Type varType;
    public Identifier varId;

    public VarDecl(Type varType, Identifier varId) {
        this.varType = varType;
        this.varId = varId;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}
