package algorithm;

class ReplaceSpaces {

    public String replaceSpace(String str) {
        char[] arr = str.toCharArray();
        int count = 0;
        int len = arr.length;
        for (int i = 0;i < len; i ++) {
            if (arr[i] == ' ') {
                count++;
            }
        }
        if (count == 0) {
            return "";
        }
        int len1 = len + count * 2;
        char[] tmp = new char[len1];
        int i = len - 1;
        int j = len1 - 1;
        while (i >= 0) {
            if (arr[i] == ' ') {
                tmp[j--] = '0';
                tmp[j--] = '2';
                tmp[j--] = '%';
            } else {
                tmp[j--] = arr[i];
            }
            i--;
        }
        return new String(tmp);
    }
}


public class Solution {

    public static void main(String[] args) {
        String str = "We are happy";
        ReplaceSpaces replace = new ReplaceSpaces();
        String res = replace.replaceSpace(str);
        System.out.println("替换结果:" + res);
    }
}
