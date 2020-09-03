package algorithm;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;

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
}

public class Solution {

    public static void main(String[] args) {
        CuttingRope rope = new CuttingRope();
        int res = rope.maxProductAfterCutting(12);
        int res2 = rope.cuttingRope(12);
        System.out.println("最大值1:" + res);
        System.out.println("最大值2:" + res);
    }
}
