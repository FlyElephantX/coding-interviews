package algorithm;

class NumericStrings {

    private int index = 0;

    public boolean isNumber(String s) {
        if (s == null || s.length() < 1) {
            return false;
        }
        //添加结束标志
        s = s + '|';
        //跳过首部的空格
        char[] chars = s.toCharArray();
        while(chars[index] == ' ') {
            index++;
        }
        boolean flag = scanInteger(chars);
        if (index < chars.length && chars[index] == '.') {
            index++;
            flag = scanUnsignedInteger(chars) || flag;
        }
        if (index < chars.length && (chars[index] == 'E' || chars[index] == 'e')) {
            index++;
            flag = flag && scanInteger(chars);
        }
        //跳过尾部空格
        while(s.charAt(index) == ' '){
            index++;
        }
        return flag && chars[index] == '|';
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
        String s = "1 ";
        boolean res = number.isNumber(s);
        if (res) {
            System.out.println("字符数字");
        } else {
            System.out.println("非字符数字");
        }
    }
}
