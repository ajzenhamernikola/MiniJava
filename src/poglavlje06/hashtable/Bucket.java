package poglavlje06.hashtable;

public class Bucket {
    public String key;
    public Object binding;
    public Bucket next;

    public Bucket(String key, Object binding, Bucket next) {
        this.key = key;
        this.binding = binding;
        this.next = next;
    }
}
