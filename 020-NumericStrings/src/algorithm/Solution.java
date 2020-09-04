package algorithm;

class NumericStrings {

    private int index = 0;

    public boolean isNumerric(char[] str) {
        if (str.length < 1) {
            return false;
        }
        boolean flag = scanInteger(str);
        if (index < str.length && str[index] == '.') {
            index++;
            flag = scanUnsignedInteger(str) || flag;
        }
        if (index < str.length && (str[index] == 'E' || str[index] == 'e')) {
            index++;
            flag = flag && scanInteger(str);
        }
        return flag && index == str.length;
    }

    private boolean scanInteger(char[] str) {
        if (index < str.length && (str[index] == '+' || str[index] == '-')) {
            index++;
        }
        return scanUnsignedInteger(str);
    }

    private boolean scanUnsignedInteger(char[] str) {
        int start = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9') {
            index++;
        }
        return start < index;
    }
}

public class Solution {

    public static void main(String[] args) {
        NumericStrings number = new NumericStrings();
        char[] str = "-1E-16".toCharArray();
        boolean res = number.isNumerric(str);
        if (res) {
            System.out.println("字符数字");
        } else {
            System.out.println("非字符数字");
        }
    }
}
