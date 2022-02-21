public class KthFactorOfN {

    /**
     * Given two positive integers n and k.
     * <p>
     * A factor of an integer n is defined as an integer i where n % i == 0
     * Consider a list of all factors of n sorted in ascending order,
     * return the kth factor in this list or return -1 if n has less than k factors.
     */
    public static int kthFactor(int n, int k) {

        int found = 0;

        int number = -1;

        for (int i = 1; i <= n && found < k; i++) {
            if (n % i == 0) {
                found++;
            }
            if (found == k) {
                number = i;
            }
        }

        return number;

    }


    public static void main(String[] args) {

        assert kthFactor(12, 3) == 3;

        assert kthFactor(7, 2) == 7;

        assert kthFactor(4, 4) == -1;

        assert kthFactor(1, 1) == 1;

        assert kthFactor(1000, 3) == 4;

    }


}

