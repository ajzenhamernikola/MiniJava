package poglavlje04.syntaxtree.vardecl;

import poglavlje04.syntaxtree.Identifier;
import poglavlje04.syntaxtree.type.Type;

public class VarDecl {
    public Type varType;
    public Identifier varId;

    public VarDecl(Type varType, Identifier varId) {
        this.varType = varType;
        this.varId = varId;
    }
}
