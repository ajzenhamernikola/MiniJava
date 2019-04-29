package poglavlje04.syntaxtree.vardecl;

import poglavlje04.syntaxtree.Identifier;
import poglavlje04.syntaxtree.type.Type;
import poglavlje04.syntaxtree.visitor.Visitor;

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
}
