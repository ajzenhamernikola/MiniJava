package poglavlje01.Exp;

public class NumExp extends Exp {
    public int num;

    public NumExp(int num) {
        this.num = num;
    }

    @Override
    public int maxargs() {
        return 1;
    }
}
