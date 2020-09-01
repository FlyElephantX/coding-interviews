package algorithm;

class Fibonacci {

    public long fibonacci(int n) {
        if (n < 2) {
            return n;
        }
        int pre1 = 0;
        int pre2 = 1;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = pre1 + pre2;
            pre1 = pre2;
            pre2 = res;
        }
        return res;
    }
}

public class Solution {

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        for (int i = 1; i <= 10; i++) {
            long res = fibonacci.fibonacci(i);
            System.out.println(res);
        }
    }
}
