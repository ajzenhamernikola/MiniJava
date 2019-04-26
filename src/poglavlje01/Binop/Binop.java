package poglavlje01.Binop;

public class Binop {
    public enum Op {
        Plus,
        Minus,
        Times,
        Div
    }

    public Op op;

    public Binop(Op op) {
        this.op = op;
    }
}
