package poglavlje04.syntaxtree.expression;

public class IdentifierExp extends Exp {
    public String identifier;

    public IdentifierExp(String identifier) {
        this.identifier = identifier;
    }
}
