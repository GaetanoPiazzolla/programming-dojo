package fb.array;

import java.util.HashSet;
import java.util.Set;


/**
 * https://leetcode.com/problems/contains-duplicate/
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++) {
            set.add(nums[i]);
        }
        return nums.length != set.size();
    }

}
