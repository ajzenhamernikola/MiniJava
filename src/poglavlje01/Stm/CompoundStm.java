package poglavlje01.Stm;

public class CompoundStm extends Stm {
    public Stm stm1;
    public Stm stm2;

    public CompoundStm(Stm stm1, Stm stm2) {
        this.stm1 = stm1;
        this.stm2 = stm2;
    }

    @Override
    public int maxargs() {
        int max1 = stm1.maxargs();
        int max2 = stm2.maxargs();
        return max1 > max2 ? max1 : max2;
    }
}
