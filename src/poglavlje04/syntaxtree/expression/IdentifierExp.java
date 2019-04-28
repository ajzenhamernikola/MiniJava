package poglavlje04.syntaxtree.expression;

public class IdentifierExp extends Exp {
    String identifier;

    public IdentifierExp(String identifier) {
        this.identifier = identifier;
    }
}
