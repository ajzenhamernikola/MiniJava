package poglavlje02;

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
