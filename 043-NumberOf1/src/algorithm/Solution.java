package algorithm;

class NumberOf1 {

    public int numberOf1Between1AndN(int n) {
        int count = 0;//1的个数
        int i = 1;//当前位
        int current = 0, after = 0, before = 0;
        while ((n / i) != 0) {
            current = (n / i) % 10; // 当前位数字
            before = n / (i * 10); // 高位数字
            after = n - (n / i) * i; // 低位数字
            //如果为0,出现1的次数由高位决定,等于高位数字 * 当前位数
            if (current == 0) {
                count += before * i;
            } else if (current == 1) {//如果为1,出现1的次数由高位和低位决定,高位*当前位+低位+1
                count += before * i + after + 1;
            } else {//如果大于1,出现1的次数由高位决定,//（高位数字+1）* 当前位数
                count += (before + 1) * i;
            }
            //前移一位
            i = i * 10;
        }
        return count;
    }

    public int numberOf1Between1AndN1(int n) {
        int ones = 0;
        for (int m = 1; m <= n; m *= 10) {
            int a = n / m;
            int b = n % m;
            int temp = a % 10;

            if (temp == 0) {
                // 情况1：当前数位为0
                ones += a / 10 * m;
            } else if (temp == 1) {
                // 情况2：当前数位为1
                ones += a / 10 * m + b + 1;
            } else {
                // 情况3：当前数位大于1
                ones += (a / 10 + 1) * m;
            }
        }
        return ones;
    }
}

public class Solution {

    public static void main(String[] args) {
        NumberOf1 number = new NumberOf1();
        int count = number.numberOf1Between1AndN1(12013);
        System.out.println("1的总数:" + count);
    }
}
