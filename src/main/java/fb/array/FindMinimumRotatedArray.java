package fb.array;

public class FindMinimumRotatedArray {

    public static int findMin(int[] nums) {
        if(nums == null || nums.length==0){
            throw new IllegalArgumentException();
        }
        if(nums.length==1) {
            return nums[0];
        }

        int start =0;
        int end = nums.length-1;

        if(nums[end] > nums[0]){
            return nums[0];
        }

        while(end - start > 1){
            int half = (start + end) / 2;
            if(half+1 < nums.length) {
                if(nums[half+1] < nums[half]){
                    return nums[half+1];
                }
            }
            if(half -1 > 0) {
                if(nums[half-1] > nums[half]){
                    return nums[half];
                }
            }
            if(nums[start] > nums[half]){
                end = half;
            }
            else if(nums [half+1] > nums[end] ) {
                start = half +1;
            }
            else {
                break;
            }
        }
        return nums[end];
    }

    public static void main(String[] args) {
        int nums[] = new int[]{3,4,5,6,1,2};
        System.out.println(findMin(nums));

        nums = new int[]{3,4,5,6,1,2,0,1,1,1,2,2};
        System.out.println(findMin(nums));

        nums = new int[]{1,2,3,4,5,0};
        System.out.println(findMin(nums));
    }
}
