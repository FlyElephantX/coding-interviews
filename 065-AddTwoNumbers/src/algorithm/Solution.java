package algorithm;

class AddTwoNumbers {

    public int add(int num1, int num2) {
        int temp = num1 ^ num2;
        num1 = temp ^ num1;
        num2 = temp ^ num1;
        return num1;
    }

    public int add1(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1; // 进位
            a = a ^ b; // 非进位和
            b = c;// 进位
        }
        return a;
    }
}

public class Solution {

    public static void main(String[] args) {
        AddTwoNumbers numbers = new AddTwoNumbers();
        int num = numbers.add(10, 100);
        System.out.println("交换后的数值:" + num);
    }
}
