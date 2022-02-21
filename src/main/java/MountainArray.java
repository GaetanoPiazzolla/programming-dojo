public class MountainArray {

    /**
     * Given an array of integers arr, return true if and only if it is a valid mountain array.
     * <p>
     * Recall that arr is a mountain array if and only if:
     * <p>
     * arr.length >= 3
     * There exists some i with 0 < i < arr.length - 1 such that:
     * arr[0] < arr[1] < ... < arr[i - 1] < A[i]
     * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
     * <p>
     * Example 1:
     * Input: arr = [2,1]
     * Output: false
     * <p>
     * Example 2:
     * Input: arr = [3,5,5]
     * Output: false
     * <p>
     * Example 3:
     * Input: arr = [0,3,2,1]
     * Output: true
     */
    public static boolean validMountainArray(int[] arr) {

        boolean asc = false;
        boolean desc = false;

        for (int i = 0; i < arr.length - 1; i++) {

            if (arr[i] == arr[i + 1]) {
                return false;
            } else if (arr[i] > arr[i + 1]) {
                desc = true;
                if (!asc) {
                    return false;
                }
            } else {
                asc = true;
                if (desc) {
                    return false;
                }
            }
        }

        return asc && desc;
    }

    public static void main(String[] args) {
        System.out.println("false: " + validMountainArray(new int[]{2, 1}));
        System.out.println("false: " + validMountainArray(new int[]{3, 5, 5}));
        System.out.println("false: " + validMountainArray(new int[]{0, 3, 3, 1}));
        System.out.println("false: " + validMountainArray(new int[]{3, 1, 3, 1}));
        System.out.println("false: " + validMountainArray(new int[]{0, 1, 2}));
        System.out.println("false: " + validMountainArray(new int[]{0, 1, 2, 3, 4, 5, 5, 3, 2, 1, 0}));
        System.out.println("true: " + validMountainArray(new int[]{0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0}));
        System.out.println("true: " + validMountainArray(new int[]{0, 3, 2, 1}));
    }

}
