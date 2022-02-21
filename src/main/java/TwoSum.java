import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    class Solution {

        public int[] twoSumBruteForce(int[] nums, int target) {
            int[] sum = new int[2];
            boolean found = false;

            for (int i = 0; i < nums.length && !found; i++) {
                for (int j = i + 1; j < nums.length && !found; j++) {
                    if (nums[i] + nums[j] == target) {
                        sum[0] = i;
                        sum[1] = j;
                        found = true;
                    }
                }
            }
            return sum;
        }

        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            int[] sum = new int[2];
            for (int i = 0; i < nums.length; i++) {
                if (map.get(target - nums[i]) != null) {
                    sum[0] = i;
                    sum[1] = map.get(target - nums[i]);
                } else {
                    map.put(nums[i], i);
                }
            }
            return sum;
        }


    }
}
