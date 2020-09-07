package algorithm;

import java.util.Arrays;

class SortArrayForMinNumber {

    public String printMinNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }
        return sb.toString();
    }

}

public class Solution {

    public static void main(String[] args) {
        int[] nums = {3, 32, 321};
        SortArrayForMinNumber minNumber = new SortArrayForMinNumber();
        String res = minNumber.printMinNumber(nums);
        System.out.println("排序结果:" + res);
    }
}
