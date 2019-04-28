package poglavlje04;

// Main class for testing the TestFac class
class Factorial {
    public static void main(String[] a) {
        System.out.println(new TestFac().ComputeFac(10));
    }
}

/* Class that implements
 * factorial numbers calculating
 */
class TestFac {

    public int ComputeFac(int num){
        int num_aux ;
        if (num < 1)
            num_aux = 1 ;
        else
            num_aux = num * (this.ComputeFac(num-1)) ;
        return num_aux ;
    }

}

// Another class to test more thoroughly
class TestFac2 {

    int member1;
    int member2;

    public int call(TestFac t) {
        int result;

        member1 = t.ComputeFac(5);
        member2 = t.ComputeFac(3);

        if (member1 < member2) {
            result = member1;
        }
        else {
            result = member2;
        }

        System.out.println(result);

        return result;
    }

}
