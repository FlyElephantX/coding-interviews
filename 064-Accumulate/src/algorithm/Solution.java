package algorithm;

class Accumulate {

    private int res = 0;

    public int sumNums(int n) {
        boolean x = n > 1 && sumNums(n - 1) > 0;
        res += n;
        return res;
    }
}

public class Solution {

    public static void main(String[] args) {
        Accumulate accumulate = new Accumulate();
        int res = accumulate.sumNums(3);
        System.out.println("序列和:" + res);
    }
}
