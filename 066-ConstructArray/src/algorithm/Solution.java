package algorithm;

import java.util.Arrays;

class ConstructArray {

    public int[] multiply(int[] a) {
        if (a.length == 0) {
            return new int[0];
        }
        int[] b = new int[a.length];
        b[0] = 1;
        for (int i = 1; i < a.length; i++) { // 下三角数据保存
            b[i] = b[i - 1] * a[i - 1];
        }
        int temp  = 1;
        for (int i = a.length - 2; i >= 0; i --) {
            temp = temp * a[i + 1];
            b[i] = temp * b[i];
        }
        return b;
    }
}


public class Solution {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        ConstructArray construct = new ConstructArray();
        int[] b = construct.multiply(a);
        System.out.println("输出的数组:" + Arrays.toString(b));
    }
}
