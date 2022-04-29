package fb.array;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BuySellStock {

    public int maxProfit(int[] prices) {
        int maxProfit = -1;
        int min = 9999999;
        for (int i = 0; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
            } else if (maxProfit < prices[i] - min) {
                maxProfit = prices[i] - min;
            }
        }
        return maxProfit > 0 ? maxProfit : 0;
    }

}
