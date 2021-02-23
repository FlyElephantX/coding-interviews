package algorithm;

class CuttingRope {

    public int maxProductAfterCutting(int target) {
        if (target < 2) {
            return 0;
        }
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        int[] products = new int[target + 1];
        for (int i = 0; i < 4; i++) {
            products[i] = i;
        }
        for (int i = 4; i <= target; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int val = products[j] * products[i - j];
                if (max < val) {
                    max = val;
                }
            }
            products[i] = max;
        }
        return products[target];
    }

    public int cuttingRope(int n) {
        if(n <= 3) {
            return n - 1;
        }
        int a = n / 3, b = n % 3;
        if(b == 0) {
            return (int)Math.pow(3, a);
        }
        if(b == 1) {
            return (int)Math.pow(3, a - 1) * 4;
        }
        return (int)Math.pow(3, a) * 2;
    }

    //  dp[i] 表示将正整数 i 拆分成至少两个正整数的和之后，这些正整数的最大乘积
    //  当 i≥2 时，假设对正整数 i 拆分出的第一个正整数是 j（1≤j<i），则有以下两种方案：
    //
    //  将 i 拆分成 j 和 i−j 的和，且 i−j 不再拆分成多个正整数，此时的乘积是 j×(i−j)；
    //  将 i 拆分成 j 和 i−j 的和，且 i−j 继续拆分成多个正整数，此时的乘积是 j×dp[i−j]
    public int cuttingRope1(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                int max = Math.max(j * (i - j), j * dp[i - j]);
                dp[i]= Math.max(dp[i], max);
            }
        }
        return dp[n];
    }

}

public class Solution {

    public static void main(String[] args) {
        CuttingRope rope = new CuttingRope();
        int res = rope.maxProductAfterCutting(12);
        int res2 = rope.cuttingRope(12);
        System.out.println("最大值1:" + res);
        System.out.println("最大值2:" + res);
        int res3 = rope.cuttingRope1(12);
        System.out.println("最大值3:" + res);
    }
}
