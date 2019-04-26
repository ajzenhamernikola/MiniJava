package poglavlje01.exp;

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
