public class PowerOf2 {

    /**
     * Prints the powers of 2 from 1 through n inclusive.
     *
     * @param n the number
     *
     * @return
     */
    static int powersOf2(int n) {
        if(n == 1) {
            System.out.println(1);
            return 1;
        }
        else{
            int prev = powersOf2(n / 2);
            int curr = prev * 2;
            System.out.println(curr);
            return curr;
        }
    }

    public static void main(String[] args) {
        PowerOf2.powersOf2(10);
    }
}
