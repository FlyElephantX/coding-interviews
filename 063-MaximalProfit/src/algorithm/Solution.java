package algorithm;

import java.util.Deque;
import java.util.LinkedList;

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

    public int maxProfit1(int[] prices) {
        Deque<Integer> minQueue = new LinkedList<>();
        int max = 0;
        for (int num : prices) {
            if (minQueue.isEmpty() || num < minQueue.peekLast()) {
                minQueue.offer(num);
            }
            max = Math.max(max, num - minQueue.peekLast());
        }
        return max;
    }

    public int maxProfit2(int[] prices) {
        int max = 0;
        int min = prices[0];
        for (int num : prices) {
            if (num <= min) {
                min = num;
            }
            max = Math.max(max, num - min);
        }
        return max;
    }



}

public class Solution {

    public static void main(String[] args) {
        int[] nums = {9, 11, 8, 5, 7, 12, 16, 14};
        MaximalProfit profit = new MaximalProfit();
        int maxProfit = profit.maxProfit(nums);
        System.out.println("最大利润的值:" + maxProfit);
        int maxProfit1 = profit.maxProfit1(nums);
        System.out.println("最大利润的值:" + maxProfit1);
        int maxProfit2 = profit.maxProfit2(nums);
        System.out.println("最大利润的值:" + maxProfit2);
    }
}
