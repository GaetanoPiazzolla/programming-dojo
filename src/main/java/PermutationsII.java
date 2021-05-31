import java.util.*;

public class PermutationsII {

    // Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
    // Input: nums = [1,2,3]
    // Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

    // Input: nums = [1,1,2]
    // Output: [[1,1,2], [1,2,1], [2,1,1]]
    public static List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);
        return permute(nums,0);
    }

    static List<List<Integer>> permute(int[] arr, int k){

        List<List<Integer>> lists = new ArrayList<>();

        for(int i = k; i < arr.length; i++){
            if( i == k || arr[i] != arr[k] )
            {
                swap(arr, i, k);
                lists.addAll(permute(arr, k+1));
                swap(arr, k, i);
            }
        }
        if (k == arr.length -1){
            List<Integer> toadd = new ArrayList<>();
            for(int i=0;i<arr.length;i++) {
                toadd.add(arr[i]);
            }
            lists.add(toadd);
        }
        return lists;
    }

    public static final  void swap (int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String args[]){

        System.out.println("6: "+ permuteUnique(new int[]{1,2,3}).size());

        System.out.println("3: "+ permuteUnique(new int[]{1,1,2}).size());

        System.out.println("3: "+ permuteUnique(new int[]{2,1,1}).size());

        System.out.println("6: "+ permuteUnique(new int[]{2,2,1,1}).size());

        System.out.println("12: "+ permuteUnique(new int[]{1,1,2,3}).size());

    }

}
