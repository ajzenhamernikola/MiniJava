package poglavlje05.symboltable;

import poglavlje05.syntaxtree.type.*;

import java.util.Hashtable;

public class SymbolTable {
    private Hashtable<Symbol, Class> hashtable;

    public SymbolTable() {
        hashtable = new Hashtable<>();
    }

    public boolean addClass(Symbol id, Symbol parent) {
        if(containsClass(id)) {
            return false;
        }
        hashtable.put(id, new Class(id, parent));
        return true;
    }

    public Class getClass(Symbol id) {
        if(containsClass(id)) {
            return hashtable.get(id);
        }
        return null;
    }

    public boolean containsClass(Symbol id) {
        return hashtable.containsKey(id);
    }

    public Type getVarType(Method m, Class c, Symbol id) {
        if(null != m) {
            if(null != m.getVar(id)) {
                return m.getVar(id).type();
            }
            if(null != m.getParam(id)){
                return m.getParam(id).type();
            }
        }

        while(null != c) {
            if(null != c.getVar(id)) {
                return c.getVar(id).type();
            }
            else {
                if(null == c.parent()) {
                    c = null;
                }
                else {
                    c = getClass(c.parent());
                }
            }
        }

        System.out.println("Variable " + id.toString() + " not defined in current scope");
        System.exit(1);
        return null;
    }

    public Method getMethod(Symbol id, Symbol classScope) {
        if(null == getClass(classScope)) {
            System.out.println("Class " + classScope.toString() + " not defined");
            System.exit(1);
        }

        Class c = getClass(classScope);
        while(null != c) {
            if(null != c.getMethod(id)) {
                return c.getMethod(id);
            }
            else {
                if(null == c.parent()) {
                    c = null;
                }
                else {
                    c = getClass(c.parent());
                }
            }
        }

        System.out.println("Method " + id.toString() + " not defined in class " + classScope.toString());

        System.exit(1);
        return null;
    }

    public Type getMethodType(Symbol id, Symbol classScope) {
        if(null == getClass(classScope)) {
            System.out.println("Class " + classScope.toString() + " not defined");
            System.exit(1);
        }

        Class c = getClass(classScope);
        while(null != c) {
            if(null != c.getMethod(id)) {
                return c.getMethod(id).type();
            }
            else {
                if(null == c.parent()) {
                    c = null;
                }
                else {
                    c = getClass(c.parent());
                }
            }
        }

        System.out.println("Method " + id.toString() + " not defined in class " + classScope.toString());
        System.exit(1);
        return null;
    }

    public boolean compareTypes(Type t1, Type t2) {
        if (t1 == null || t2 == null) {
            return false;
        }

        if (t1 instanceof IntType && t2 instanceof IntType) {
            return true;
        }
        if (t1 instanceof BooleanType && t2 instanceof BooleanType) {
            return true;
        }
        if (t1 instanceof IntArrayType && t2 instanceof IntArrayType) {
            return true;
        }
        if (t1 instanceof IdentifierType && t2 instanceof IdentifierType) {
            IdentifierType i1 = (IdentifierType)t1;
            IdentifierType i2 = (IdentifierType)t2;

            Symbol s1 = Symbol.symbol(i1.identifier);
            Symbol s2 = Symbol.symbol(i2.identifier);

            Class c = getClass(s2);
            while(null != c) {
                if (s1.equals(c.getId())) {
                    return true;
                }
                if(c.parent() == null) {
                    return false;
                }
                c = getClass(c.parent());
            }
        }
        return false;
    }
}
