public class MissingPositiveNumber {

    /**
     * Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
     * <p>
     * Find the kth positive integer that is missing from this array.
     */
    public static int findKthPositive(int[] arr, int k) {

        // { 2, 3, 4, 7, 11 } = > 5

        int intialDiff = k - arr[0] + 1;
        if (intialDiff <= 0) {
            return k;
        } else {
            k = intialDiff;
        }

        int i = 0;
        for (; i < arr.length - 1; i++) {

            int diff = k - (arr[i + 1] - arr[i] - 1);

            if (diff <= 0) {
                return arr[i] + k;
            }

            k = diff;
        }

        return arr[i] + k;

    }


    public static void main(String[] args) {

        System.out.println(findKthPositive(new int[]{2}, 3));

    }


}
