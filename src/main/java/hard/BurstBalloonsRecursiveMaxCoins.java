package hard;

import java.util.*;

public class BurstBalloonsRecursiveMaxCoins {

    static Map<Integer, Integer> cache = new HashMap<>();

    public static int maxCoins(int[] nums) {

        int maxCoins = recursiveMaxCoins(nums, 0);
        return maxCoins == -1 ? 0 : maxCoins;

    }

    public static int recursiveMaxCoins(int[] nums, int coins) {

        int maxCoins = -1;

        if (nums.length == 1) {
            maxCoins = nums[0];
        }

        else {
            int hash = Arrays.hashCode(nums);
            if (cache.containsKey(hash)) {
                maxCoins = cache.get(hash);
            }
        }

        if (maxCoins == -1) {

            int tempCoins = 0;

            for (int i = 0; i <= nums.length - 1; i++) {

                if (i == 0) {
                    tempCoins = nums[i] * nums[i + 1];
                } else if (i == nums.length - 1) {
                    tempCoins = nums[i - 1] * nums[i];
                } else {
                    tempCoins = nums[i - 1] * nums[i] * nums[i + 1];
                }

                int[] numsNoI = removeIndex(nums, i);

                tempCoins = recursiveMaxCoins(numsNoI, tempCoins);

                if (tempCoins > maxCoins) {
                    maxCoins = tempCoins;
                }

            }

            cache.put(Arrays.hashCode(nums), maxCoins);

        }

        return maxCoins + coins;
    }

    public static int maxCoinsPro(int[] nums) {

        if (nums.length == 0)
            return 0;

        if (nums.length == 1)
            return nums[0];

        int n = nums.length;

        int dp[][] = new int[n + 1][n + 1];


        for (int len = 1; len <= n; len++) {

            for (int i = 0; i < n - len + 1; i++) {

                int j = i + len - 1;
                int max = 0;
                for (int k = i; k <= j; k++) {

                    int leftSide = 0, rightSide = 0, byItSelf = nums[k];

                    if (k - 1 >= i)
                        leftSide = dp[i][k - 1];

                    if (k + 1 <= j)
                        rightSide = dp[k + 1][j];

                    if (i != 0) // if they are at boundary
                        byItSelf *= nums[i - 1];

                    if (j != n - 1) // if they are at boundary
                        byItSelf *= nums[j + 1];

                    max = Math.max(max, leftSide + rightSide + byItSelf);

                }
                dp[i][j] = max;
            }

        }


        return dp[0][n - 1];
    }

    public static int[] removeIndex(int[] arr, int index) {
        if (arr == null || index < 0 || index >= arr.length) {
            return arr;
        }
        int[] anotherArray = new int[arr.length - 1];
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }
            anotherArray[k++] = arr[i];
        }
        return anotherArray;
    }

    public static void main(String[] args) {

        int[] array = new int[]{3,4,3,5,0,1,0,2,1,1,1};
        long start;

        start = System.currentTimeMillis();
        System.out.println(maxCoinsPro(array));
        System.out.println("this algorithm spent: " +(System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        System.out.println(maxCoins(array));
        System.out.println("my algoritm spent: "+ (System.currentTimeMillis() - start));

    }

}
