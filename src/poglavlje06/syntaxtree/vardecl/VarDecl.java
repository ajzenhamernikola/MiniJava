package poglavlje06.syntaxtree.vardecl;

import poglavlje06.syntaxtree.Identifier;
import poglavlje06.syntaxtree.type.Type;
import poglavlje06.visitor.TypeVisitor;
import poglavlje06.visitor.Visitor;

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
