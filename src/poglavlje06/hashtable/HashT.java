package poglavlje06.hashtable;

public class HashT {
    final int SIZE = 256;
    Bucket table[] = new Bucket[SIZE];

    private int hash(String s) {
        int h = 0;
        for (int i = 0; i < s.length(); ++i) {
            h = h * 65599 + s.charAt(i);
        }
        return h;
    }

    public void insert(String s, Bucket b) {
        int index = hash(s) % SIZE;
        table[index] = new Bucket(s, b, table[index]);
    }

    public Object lookup(String s) {
        int index = hash(s) % SIZE;
        for (Bucket b = table[index]; null != b; b = b.next) {
            if (s.equals(b.key)) {
                return b.binding;
            }
        }
        return null;
    }

    public void pop(String s) {
        int index = hash(s) % SIZE;
        table[index] = table[index].next;
    }
}
