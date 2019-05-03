package poglavlje06.symboltable;

import poglavlje06.syntaxtree.type.IdentifierType;
import poglavlje06.syntaxtree.type.Type;

import java.util.Enumeration;
import java.util.Hashtable;

public class Class {
    private Symbol id;
    private Hashtable<Symbol, Method> methods;
    private Hashtable<Symbol, Variable> globals;
    private Symbol parent;
    private Type type;

    public Class(Symbol id, Symbol p) {
        this.id = id;
        parent = p;
        type = new IdentifierType(id.toString());
        methods = new Hashtable<>();
        globals = new Hashtable<>();
    }

    public Class() {}

    public Symbol getId() {
        return id;
    }

    public Type type() {
        return type;
    }

    public boolean addMethod(Symbol id, Type type) {
        if(containsMethod(id)) {
            return false;
        }
        methods.put(id, new Method(id, type));
        return true;
    }

    public Enumeration getMethods(){
        return methods.keys();
    }

    public Method getMethod(Symbol id) {
        if(containsMethod(id)) {
            return methods.get(id);
        }
        return null;
    }

    public boolean addVar(Symbol id, Type type) {
        if(globals.containsKey(id)) {
            return false;
        }
        globals.put(id, new Variable(id, type));
        return true;
    }

    public Variable getVar(Symbol id) {
        if(containsVar(id)) {
            return globals.get(id);
        }
        return null;
    }

    private boolean containsVar(Symbol id) {
        return globals.containsKey(id);
    }

    private boolean containsMethod(Symbol id) {
        return methods.containsKey(id);
    }

    public Symbol parent() {
        return parent;
    }
}
