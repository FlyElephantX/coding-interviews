package algorithm;

import java.util.*;

class DicesProbability {

    public double[] dicesSum(int n) {
        double[] sum = new double[5 * n + 1];
        int m = n;
        double maxValue = Math.pow(6, n);
        for (int i = 0; i < sum.length; i++) {
            sum[i] = diceCount(m ,n) / maxValue;
            m++;
        }
        return sum;
    }

    public long diceCount(int m, int n) { // m 总和 n 骰子个数
        if (m <= 0) {
            return 0;
        }
        if (n == 1) {
            return m <= 6 ? 1 : 0;
        }
        return diceCount(m - 1, n - 1) + diceCount(m - 2, n - 1) + diceCount(m - 3, n - 1) + diceCount(m - 4, n - 1) + diceCount(m - 5, n - 1) + diceCount(m - 6, n - 1);
    }

    public double[] twoSum(int n) {
        int[][] dp = new int[n + 1][6 * n + 1];
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) { // 2个骰子到n个骰子
            for (int j = i; j <= 6 * i; j++) {  // 结果从 i( i 个骰子都是1) 到 6 * i (都是6)
                for (int k = 1; k <= 6; k++) {  // 单独的骰子的结果（从 1 到 6 ）
                    if(j - k < i - 1){
                        break;
                    }
                    dp[i][j] += dp[i-1][j - k];
                }
            }
        }
        double[] res = new double[5 * n + 1];
        double sum = Math.pow(6,n);
        for (int i = 0; i < res.length; i++) {
            res[i] = dp[n][n + i] / sum;
        }
        return res;
    }
}

public class Solution {

    public static void main(String[] args) {
        DicesProbability probability = new DicesProbability();
        double[] res1 = probability.dicesSum(2);
        System.out.println("骰子出现的概率:" + Arrays.toString(res1));
        double[] res2 = probability.twoSum(2);
        System.out.println("骰子出现的概率:" + Arrays.toString(res2));
    }
}
