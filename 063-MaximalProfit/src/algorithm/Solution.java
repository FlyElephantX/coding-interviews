package algorithm;

class MaximalProfit {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                int diff = prices[i] - min;
                if (diff > maxProfit) {
                    maxProfit = diff;
                }
            }
        }
        return maxProfit;
    }

}

public class Solution {

    public static void main(String[] args) {
        int[] nums = {9, 11, 8, 5, 7, 12, 16, 14};
        MaximalProfit profit = new MaximalProfit();
        int maxProfit = profit.maxProfit(nums);
        System.out.println("最大利润的值:" + maxProfit);
    }
}
