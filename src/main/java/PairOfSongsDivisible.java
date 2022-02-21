import java.util.Arrays;

public class PairOfSongsDivisible {

    public static int numPairsDivisibleBy60(int[] time) {

        int numPairs = 0;
        int[] count = new int[60];
        // this is useless
        Arrays.fill(count, 0);

        // we can do this in the same for loop.
        for (int i = 0; i < time.length; i++) {
            ++count[time[i] % 60];
        }

        for (int i = 0; i < 60; i++) {
            if (i == 0 || i == 30) {
                if (count[i] > 1) {
                    numPairs += sumFactorial(count[i] - 1);
                    count[i] = 0;
                }
            } else {
                if (count[i] > 0 && count[60 - i] > 0) {
                    numPairs += count[i] * count[60 - i];
                    count[i] = 0;
                    count[60 - i] = 0;
                }
            }
        }

        return numPairs;
    }

    private static int sumFactorial(int i) {
        int sum = 0;
        while (i > 0) {
            sum += i;
            i--;
        }
        return sum;
    }

    public static void main(String[] args) {

        assert (numPairsDivisibleBy60(new int[]{60, 60, 60}) == 3);
        assert (numPairsDivisibleBy60(new int[]{60}) == 0);
        assert (numPairsDivisibleBy60(new int[]{60, 60}) == 1);
        assert (numPairsDivisibleBy60(new int[]{60, 60, 60}) == 3);
        assert (numPairsDivisibleBy60(new int[]{60, 60, 60, 60}) == 6);
        assert (numPairsDivisibleBy60(new int[]{60, 60, 60, 60, 60}) == 10);
        assert (numPairsDivisibleBy60(new int[]{60, 60, 60, 60, 60, 60}) == 15);

        assert (numPairsDivisibleBy60(new int[]{1, 59}) == 1);
        assert (numPairsDivisibleBy60(new int[]{1, 1, 59}) == 2);
        assert (numPairsDivisibleBy60(new int[]{1, 1, 59, 59}) == 4);
        assert (numPairsDivisibleBy60(new int[]{1, 1, 1, 59, 59}) == 6);
        assert (numPairsDivisibleBy60(new int[]{1, 1, 1, 59, 59, 59}) == 9);
        assert (numPairsDivisibleBy60(new int[]{1, 1, 1, 59, 59, 59, 60, 60}) == 10);
        assert (numPairsDivisibleBy60(new int[]{1, 1, 1, 59, 59, 59, 0, 60}) == 10);
        assert (numPairsDivisibleBy60(new int[]{1, 1, 1, 59, 59, 59, 60, 0}) == 10);

        assert (numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40}) == 3);


    }

    public int bestSolution(int[] time) {
        int[] remainders = new int[60];
        int res = 0;
        for (int t : time) {
            if (t % 60 == 0) {
                res += remainders[t % 60];
            } else {
                res += remainders[60 - t % 60];
            }
            remainders[t % 60]++;
        }
        return res;
    }

}
