package poglavlje05.symboltable;

import poglavlje05.syntaxtree.type.Type;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class Method {
    private Symbol id;
    private Type type;
    private Vector<Variable> params;
    private Hashtable<Symbol, Variable> vars;

    public Method(Symbol id, Type type) {
        this.id = id;
        this.type = type;
        vars = new Hashtable<>();
        params = new Vector<>();
    }

    public Symbol getId() {
        return id;
    }

    public Type type() {
        return type;
    }

    public boolean addParam(Symbol id, Type type) {
        if(containsParam(id)) {
            return false;
        }
        params.addElement(new Variable(id, type));
        return true;
    }

    public Enumeration getParams(){
        return params.elements();
    }

    public Variable getParamAt(int i) {
        if (i < params.size()) {
            return params.elementAt(i);
        }
        return null;
    }

    public boolean addVar(Symbol id, Type type) {
        if(vars.containsKey(id)) {
            return false;
        }
        vars.put(id, new Variable(id, type));
        return true;
    }

    private boolean containsVar(Symbol id) {
        return vars.containsKey(id);
    }

    private boolean containsParam(Symbol id) {
        for (int i = 0; i < params.size(); ++i) {
            if (params.elementAt(i).id.equals(id)) {
                return true;
            }
        }
        return false;
    }

    public Variable getVar(Symbol id) {
        if(containsVar(id)) {
            return vars.get(id);
        }
        return null;
    }

    public Variable getParam(Symbol id) {
        for (int i = 0; i < params.size(); ++i) {
            if (params.elementAt(i).id.equals(id)) {
                return params.elementAt(i);
            }
        }
        return null;
    }
}
