public class DuplicateNumFloyd {

    /**
     * https://leetcode.com/problems/find-the-duplicate-number/
     */
    public static int findDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return -1;
        }

        int slow = 0;
        int fast = 0;
        int finder = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        while (true)
        {
            slow = nums[slow];
            finder = nums[finder];
            if (slow == finder)
                return slow;
        }
    }

    public static void main(String[] args){
        System.out.println(findDuplicate(new int[]{1,1,2}));
        System.out.println(findDuplicate(new int[]{1,1,2,3,4,5,6}));
        System.out.println(findDuplicate(new int[]{1,2,3,4,5,6,6}));
    }

}
