package poglavlje05.symboltable;

public class Table {
    private java.util.Dictionary dict = new java.util.Hashtable<>();
    private Symbol top;
    private Bucket marks;

    public Table() {
    }

    public void put(Symbol key, Object value) {
        dict.put(key, new Bucket(top, value, (Bucket)dict.get(key)));
        top = key;
    }

    public Object get(Symbol key) {
        Bucket value = (Bucket)dict.get(key);
        if (null != value) {
            return value.binding;
        }
        return null;
    }

    public void beginScope() {
        marks = new Bucket(top, null, marks);
        top = null;
    }

    public void endScope() {
        while (null != top) {
            Bucket value = (Bucket) dict.get(top);
            if (null != value.next) {
                dict.put(top, value.next);
            }
            else {
                dict.remove(top);
            }
            top = value.key;
        }
        top = marks.key;
        marks = marks.next;
    }

    public java.util.Enumeration keys() {
        return dict.keys();
    }
}
