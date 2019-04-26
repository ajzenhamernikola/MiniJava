package poglavlje01;

import poglavlje01.Binop.Binop;
import poglavlje01.Exp.EseqExp;
import poglavlje01.Exp.IdExp;
import poglavlje01.Exp.NumExp;
import poglavlje01.Exp.OpExp;
import poglavlje01.ExpList.LastExpList;
import poglavlje01.ExpList.PairExpList;
import poglavlje01.Stm.AssignStm;
import poglavlje01.Stm.CompoundStm;
import poglavlje01.Stm.PrintStm;
import poglavlje01.Stm.Stm;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
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

        ArrayList<String> allowedMethods = new ArrayList<>();
        allowedMethods.add("maxargs");
        allowedMethods.add("interpret");

        Method[] methods = Stm.class.getMethods();
        for (Method met : methods)
        {
            if (allowedMethods.contains(met.getName()))
            {
                System.out.println("Invoking method: " + met.getName());
                try {
                    Object ret = met.invoke(prog);

                    System.out.println("\tReturn value: " + ret.toString());
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
