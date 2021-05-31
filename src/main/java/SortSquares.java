import java.util.Arrays;

public class SortSquares {

        public static int[] sortedSquares(int[] nums) {

            int[] result = new int[nums.length];

            // first positive number
            int k = nums.length;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= 0) {
                    k = i;
                    break;
                }
            }


            /*
             * Positive array goes from k+1 to nums.length
             * Negative array goes from 0 to k
             */
            int min = k - 1;
            int max = k;
            int i = 0;

            for (; i < nums.length && min >= 0 && max < nums.length; i++) {

                if (Math.abs(nums[min]) < Math.abs(nums[max])) {
                    result[i] = nums[min] * nums[min];
                    min--;
                } else {
                    result[i] = nums[max] * nums[max];
                    max++;
                }
            }

            while (min >= 0 && i < nums.length) {
                result[i] = nums[min] * nums[min];
                min--;
                i++;
            }

            while (max < nums.length && i < nums.length) {
                result[i] = nums[max] * nums[max];
                max++;
                i++;
            }

            return result;
        }

    public static void main(String[] args) {

        int[] a = sortedSquares(new int[]{-1, -1, -1, 0});
        System.out.println(Arrays.toString(a));
    }


}
