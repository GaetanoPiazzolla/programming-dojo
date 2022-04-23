package fb;

import java.util.Arrays;

public class RemoveElement {

    public static int removeElement(int[] nums, int val) {

        int size = nums.length;

        if(size==0){
            return 0;
        }

        for(int i=0, j=nums.length-1; i<nums.length && j>=i; i++)
        {
            if(nums[i]==val) {
                size--;
                while (j>i && nums[j] == val) {
                    j--;
                    size--;
                }
                if (nums[j] != val) {
                    nums[i] = nums[j];
                    j--;
                }
            }
        }

        return Math.max(size, 0);
    }

    public static void main(String[] args){
        int[] arr = new int[]{1,4,1,4,1,4,4,4,4,4,1};
        int val = removeElement(arr,4);
        System.out.println(val);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{4,4,4,4};
        val = removeElement(arr,4);
        System.out.println(val);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{1,1,1,1};
        val = removeElement(arr,4);
        System.out.println(val);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{1};
        val = removeElement(arr,1);
        System.out.println(val);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{4,4,1,1,4,4,1};
        val = removeElement(arr,4);
        System.out.println(val);
        System.out.println(Arrays.toString(arr));
    }

}
