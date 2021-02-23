package algorithm;

class NumberOf1InBinary {

    public int numberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public int hammingWeight1(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

}

public class Solution {

    public static void main(String[] args) {
        NumberOf1InBinary binary = new NumberOf1InBinary();
        int count = binary.numberOf1(15);
        System.out.println("1的个数:" + count);
        int count1 = binary.hammingWeight(15);
        System.out.println("1的个数:" + count1);
        int count2 = binary.hammingWeight1(15);
        System.out.println("1的个数:" + count2);
    }
}
