package poglavlje06.symboltable;

public class Bucket {
    public Symbol key;
    public Object binding;
    public Bucket next;

    public Bucket(Symbol key, Object binding, Bucket next) {
        this.key = key;
        this.binding = binding;
        this.next = next;
    }
}
