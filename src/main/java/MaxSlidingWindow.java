public class MaxSlidingWindow {

    public static void main(String[] args) {
        MaxSlidingWindow m = new MaxSlidingWindow();
//        printArray(m.maxSlidingWindow(new int[]{-1,1},1));
//        printArray(m.maxSlidingWindow(new int[]{9,11},2));
//        printArray(m.maxSlidingWindow(new int[]{4,-2},2));

        printArray(m.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));


    }

    private static void printArray(int[] maxSlidingWindow) {
        for (int j : maxSlidingWindow) {
            System.out.println(j);
        }
        System.out.println(" ");
    }

    /**
     * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
     * <p>
     * Return the max sliding window.
     * <p>
     * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
     * Output: [3,3,5,5,6,7]
     * <p>
     * Input: nums = [9,11], k = 2
     * Output: [11]
     * <p>
     * Input: nums = [1,-1], k = 1
     * Output: [1,-1]
     * <p>
     * Constraints:
     * 1 <= nums.length <= 105
     * -104 <= nums[i] <= 104
     * 1 <= k <= nums.length
     */
    public int[] maxSlidingWindow(int[] nums, int k) {

        if (k == 1) {
            return nums;
        }

        int maximusSize = nums.length - k + 1;
        maximusSize = maximusSize > 0 ? maximusSize : 1;

        int[] maximusArray = new int[maximusSize];

        Integer max = null;
        int maxPosition = -1;

        for (int i = 0; i < maximusSize; i++) {

            if (maxPosition == i - 1) {

                max = null;

                for (int in = i; in < i + k; in++) {
                    if (max == null || nums[in] > max) {
                        max = nums[in];
                        maxPosition = in;
                    }
                }
            } else {

                int position = i + k - 1;

                if (max == nums[position]) {
                    maxPosition = position;
                }

                if (max < nums[position]) {
                    maxPosition = position;
                    max = nums[position];
                }

            }

            maximusArray[i] = max;

        }

        return maximusArray;

    }

}
