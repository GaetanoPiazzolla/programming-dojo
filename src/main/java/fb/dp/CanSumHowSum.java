package fb.dp;

import java.util.Arrays;

public class CanSumHowSum {

    /**
     * Check if the targetSum can be obtained by the sum of the elements of the array.
     * Elements can be used multiple times.
     */
    public boolean canSum(int targetSum, int[] nums) {

        // TODO I can cache targetSum.

        if (targetSum == 0) {
            return true;
        }
        if (targetSum < 0) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            if (canSum(targetSum - nums[i], nums)) {
                return true;
            }
        }

        return false;
    }

    public int[] howSum(int targetSum, int[] nums) {

        // TODO I can cache targetSum.

        if (targetSum == 0) {
            return new int[]{};
        }
        if (targetSum < 0) {
            return null;
        }
        for (int num : nums) {
            int[] tempArray = howSum(targetSum - num, nums);
            if (tempArray != null) {
                tempArray = Arrays.copyOf(tempArray, tempArray.length + 1);
                tempArray[tempArray.length - 1] = num;
            }
        }
        return null;
    }

}
