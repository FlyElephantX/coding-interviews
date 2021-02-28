package algorithm;

class ReverseWordsInSentence {

    public String reverse(String str) {
        str = str.trim(); // 字符串去除首尾空格
        char[] arr = str.toCharArray();
        int len = arr.length;
        reverse(arr, 0 , len - 1);
        System.out.println("翻转:" + new String(arr));
        int start = 0;
        int end = 0;
        while (end < len) {
            if (arr[end] == ' ') {
                reverse(arr, start, end - 1);
                start = end + 1;
            }
            if (end == len - 1) {
                reverse(arr, start, end);
                break;
            }
            end++;
        }
        return new String(arr);
    }

    private void reverse(char[] chars, int start, int end) {
        int len = end - start + 1;
        for (int i = 0; i < len / 2; i ++) {
            Character cur = chars[start + i];
            chars[start + i] = chars[end - i];
            chars[end - i] = cur;
        }
    }

    public String leftRotateString(String str, int num) {
        char[] chars = str.toCharArray();
        int len = str.length();
        reverse(chars, 0, len - 1);
        reverse(chars, 0, len - 1 - num);
        reverse(chars, len - num, len - 1);
        return new String(chars);
    }

}

public class Solution {

    public static void main(String[] args) {
        String str = "  hello world!  ";
        ReverseWordsInSentence sentence = new ReverseWordsInSentence();
        String res = sentence.reverse(str);
        System.out.println("翻转结果:" + res);
        String roateStr = "abcdefg";
        String roateRes = sentence.leftRotateString(roateStr, 2);
        System.out.println("左旋转之后的字符串:" + roateRes);
    }
}
