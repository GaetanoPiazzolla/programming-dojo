package fb.array;

public class MaxSubArray {

    public static int maxSubArrayWrong(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = nums[i] + max;
        }

        int upperLimit = nums.length - 1;
        int lowerLimit = 0;
        int temp = max;
        for (int i = 0; i < nums.length - 1; i++) {

            int val1 = temp - nums[lowerLimit];
            int val2 = temp - nums[upperLimit];

            if (val1 > val2) {
                if (val1 > max) {
                    max = val1;
                }
                temp = val1;
                lowerLimit++;
            } else {
                if (val2 > max) {
                    max = val2;
                }
                temp = val2;
                upperLimit--;
            }
        }

        return max;

    }

    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int currSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            currSum = currSum + nums[i];

            if (currSum > max) {
                max = currSum;
            }
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{-2, -1};
        System.out.println(maxSubArray(nums));
    }

}

