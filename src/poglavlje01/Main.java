package poglavlje01;

import poglavlje01.binop.Binop;
import poglavlje01.exp.EseqExp;
import poglavlje01.exp.IdExp;
import poglavlje01.exp.NumExp;
import poglavlje01.exp.OpExp;
import poglavlje01.expList.LastExpList;
import poglavlje01.expList.PairExpList;
import poglavlje01.stm.AssignStm;
import poglavlje01.stm.CompoundStm;
import poglavlje01.stm.PrintStm;
import poglavlje01.stm.Stm;

public class Main {

    public static void main(String[] args) {

        // a := 5 + 3 ;
        // b := ( print ( a , a - 1 ) , 10 * a ) ;
        // print ( b )

        Stm prog =
            new CompoundStm(
                new AssignStm(
                "a",
                    new OpExp(
                        new NumExp(5),
                        new Binop(Binop.Op.Plus),
                        new NumExp(3)
                    )
                ),
                new CompoundStm(
                    new AssignStm(
                    "b",
                        new EseqExp(
                            new PrintStm(
                                new PairExpList(
                                    new IdExp("a"),
                                    new LastExpList(
                                        new OpExp(
                                            new IdExp("a"),
                                            new Binop(Binop.Op.Minus),
                                            new NumExp(1)
                                        )
                                    )
                                )
                            ),
                            new OpExp(
                                new NumExp(10),
                                new Binop(Binop.Op.Times),
                                new IdExp("a")
                            )
                        )
                    ),
                    new PrintStm(
                        new LastExpList(
                            new IdExp("b")
                        )
                    )
                )
            );

//        System.out.println(prog.maxargs());
        try {
//            System.out.println(prog.interpStm(null));
            prog.interpStm(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
