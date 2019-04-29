package poglavlje05.syntaxtree.util;

import java.util.Vector;

public abstract class SyntaxList<T> {
    private Vector list;

    public SyntaxList() {
        list = new Vector();
    }

    public void add(T n) {
        list.addElement(n);
    }

    public T elementAt(int i) {
        return (T) list.elementAt(i);
    }

    public int size() {
        return list.size();
    }
}
