package poglavlje01.binop;

public class Binop {
    public enum Op {
        Plus,
        Minus,
        Times,
        Div
    }

    public Binop.Op op;

    public Binop(Binop.Op op) {
        this.op = op;
    }
}
