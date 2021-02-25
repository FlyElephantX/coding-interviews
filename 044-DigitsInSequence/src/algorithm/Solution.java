package algorithm;

class DigitsInSequence {

    public int digitAtIndex(int index) {
        if (index < 0) {
            return -1;
        }
        int digits = 1;
        while (true) {
            int numbers = countOfIntegers(digits);
            if (index < numbers * digits) {
                return digitAtIndex(index, digits);
            }
            index -= numbers * digits;
            digits++;
        }
    }

    public int digitAtIndex(int index, int digits) {
        int number = beginNumber(digits) + index / digits;
        // 从左到右第m位，就是从右到左的第digits-m位
        int indexFromRight = digits - index % digits;
        for (int i = 1; i < indexFromRight; i++) {
            number /= 10;
        }
        return number % 10;
    }

    public int countOfIntegers(int digits) {
        if (digits == 1) {
            return 10;
        }
        int count = (int) Math.pow(10,digits - 1);
        return 9 * count;

    }

    public int beginNumber(int digits) {
        if (digits == 1) {
            return 0;
        }
        return  (int) Math.pow(10, digits - 1);
    }

    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }

}

public class Solution {

    public static void main(String[] args) {
        DigitsInSequence sequence = new DigitsInSequence();
        int res = sequence.digitAtIndex(0);
        System.out.println("数字序列中某一位的数字:" + res);
        int s = -1 % 1;
        int res1 = sequence.findNthDigit(0);
        System.out.println("数字序列中某一位的数字:" + res1);
    }
}
