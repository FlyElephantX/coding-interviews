package algorithm;

class StringToInt {

    public int strToInt(String str) {
        char[] chars = str.toCharArray();
        int res = 0;
        int sign = 1;
        int index = 0;
        int border = Integer.MAX_VALUE / 10;

        while(index < str.length() && chars[index] == ' ') {//去除开头空格
            index++;
        }
        if (index >= str.length()) {
            return 0;
        }
        if (chars.length <= 0) {
            return 0;
        }
        if (chars[index] == '-') {
            sign = -1;
            index++;
        } else if (chars[index] == '+') {
            sign = 1;
            index++;
        }
        while (index < chars.length) {
            char curChar = chars[index];
            if (curChar < '0' || curChar > '9') {
                break;
            }
            if (res > border || (res == border && curChar > '7')) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res * 10 + curChar - '0';
            index++;
        }
        return sign * res;
    }
}

public class Solution {

    public static void main(String[] args) {
        StringToInt stringToInt = new StringToInt();
        String str = "+1";
        int num = stringToInt.strToInt(str);
        System.out.println("字符串转数字:" + num);
    }
}
