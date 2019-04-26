package poglavlje01.Exp;

public class IdExp extends Exp {
    public String id;

    public IdExp(String id) {
        this.id = id;
    }

    @Override
    public int maxargs() {
        return 1;
    }
}
