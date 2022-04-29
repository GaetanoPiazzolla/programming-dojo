package fb.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Robbing {

    public static int rob(int[] nums) {

        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }

        List<Integer> amounts = new ArrayList<>();

        robbing(amounts,nums,-2,0);

        return amounts.stream().max(Comparator.naturalOrder()).get();
    }

    public static void robbing(List<Integer> amounts, int[] nums, int index, int currentAmount) {
        if(index>=0){
            currentAmount+=nums[index];
        }
        if(index + 2 < nums.length){
            robbing(amounts,nums,index+2,currentAmount);
        }
        if(index + 3 < nums.length){
            robbing(amounts,nums,index+3,currentAmount);
        }
        else {
            amounts.add(currentAmount);
        }
    }

    public static int robDp(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;
        int temp = 0;
        // rob1, rob2, n, n+1
        for (int i = 0; i < nums.length; i++) {
            temp = Math.max(rob2, rob1+nums[i]);
            rob1=rob2;
            rob2=temp;
        }
        return rob2;
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,3,1})); // 4
        System.out.println(rob(new int[]{1,5,3,1})); // 6
        System.out.println(robDp(new int[]{0, 10,0,30,10000})); //10000

    }
}
