package poglavlje05.symboltable;

public class Symbol {
    private String name;
    private static java.util.Dictionary<String, Object> dict
            = new java.util.Hashtable<>();

    private Symbol(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public static Symbol symbol(String n) {
        String u = n.intern();
        Symbol s = (Symbol)dict.get(u);

        if (null == s) {
            s = new Symbol(u);
            dict.put(u, s);
        }
        return s;
    }
}
