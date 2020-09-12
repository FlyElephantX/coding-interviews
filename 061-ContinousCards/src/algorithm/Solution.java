package algorithm;

import java.util.Arrays;

class ContinousCards {

    public boolean isContinuous(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Arrays.sort(nums);
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            }
        }
        int gap = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int diff = nums[i + 1] - nums[i];
            if (nums[i] > 0 && diff > 0) {
                gap = gap + nums[i + 1] - nums[i] - 1;
            }
            if (nums[i] > 0 && diff == 0) {
                return false;
            }
        }
        if (gap <= zeroCount) {
            return true;
        } else {
            return false;
        }
    }
}

public class Solution {

    public static void main(String[] args) {
        int[] nums = {11, 0, 9, 0, 0};
        ContinousCards cards = new ContinousCards();
        boolean res = cards.isContinuous(nums);
        if (res) {
            System.out.println(Arrays.toString(nums) + "是顺子");
        } else {
            System.out.println(Arrays.toString(nums) + "不是顺子");
        }
    }
}
