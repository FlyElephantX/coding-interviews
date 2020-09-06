package algorithm;

class StringPermutation {

    public void permutation(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        char[] ca = str.toCharArray();
        permutation(ca, 0);
    }

    public void permutation(char[] ca, int begin) {
        if (begin == ca.length) {
            System.out.println(String.valueOf(ca));
        } else {
            for (int i = begin; i < ca.length; i++) {
                swap(ca, i, begin);
                // 固定位之后的序列进行全排列
                permutation(ca, begin + 1);
                swap(ca, i, begin);
            }
        }
    }

    public void swap(char[] ca, int i, int j) {
        char temp = ca[i];
        ca[i] = ca[j];
        ca[j] = temp;
    }

}

public class Solution {

    public static void main(String[] args) {
        StringPermutation permutation = new StringPermutation();
        permutation.permutation("abc");
    }
}
