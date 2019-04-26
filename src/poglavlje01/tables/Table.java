package poglavlje01.tables;

public class Table {
    public String id;
    public int value;
    public Table tail;

    public Table(String id, int value, Table tail) {
        this.id = id;
        this.value = value;
        this.tail = tail;
    }

    @Override
    public String toString() {
        return this.id + " -> " + this.value + (null != this.tail ? (", " + this.tail.toString()) : "");
    }

    public int lookup(String id) throws Exception {
        if (this.id.equals(id)) {
            return value;
        }

        if (null != tail) {
            return tail.lookup(id);
        }

        throw new Exception("Could not find a value for id " + id);
    }

    public Table exists(String id) {
        if (this.id.equals(id)) {
            return this;
        }

        if (null != tail) {
            return tail.exists(id);
        }

        return null;
    }
}
