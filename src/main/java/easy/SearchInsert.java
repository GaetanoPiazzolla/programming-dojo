package easy;

public class SearchInsert {

    public static int searchInsert(int[] nums, int target) {

        int min = 0;
        int max = nums.length - 1;

        if (target > nums[max]) {
            return nums.length;
        }
        if (target < nums[min]) {
            return 0;
        }

        int med = 0;
        int prevMed = 1;
        while (prevMed != med) {
            prevMed = med;
            med = ((max - min) / 2) + min;
            if (nums[med] > target) {
                max = med;
            } else if (nums[med] < target) {
                min = med;
            } else {
                return med;
            }
        }

        if (nums[med] < target) {
            return med + 1;
        } else {
            return med;
        }
    }

    public static void main(String[] args) {
        SearchInsert.searchInsert(new int[]{1, 2, 3}, 1);
    }


}
