package algorithm;

class NumbersAppearOnce {

    public void findNumsAppearOnce(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        int index = findFirstBitIs1(res);
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (isBit1(nums[i], index)) {
                num1 = num1 ^ nums[i];
            } else {
                num2 = num2 ^ nums[i];
            }
        }
        System.out.println("存在的两个数字:" + num1 + "---" + num2);
    }

    public boolean isBit1(int num, int indexBit) {
        return ((num >> indexBit) & 1) == 1;
    }

    public int findFirstBitIs1(int num) {
        int indexBit = 0;
        while ((num & 1) == 0 && indexBit < 32) {
            num = num >> 1;
            indexBit++;
        }
        return indexBit;
    }

}


public class Solution {

    public static void main(String[] args) {
        NumbersAppearOnce number = new NumbersAppearOnce();
        int[] nums = {2, 4, 3, 6, 3, 2, 5, 5};
        number.findNumsAppearOnce(nums);
    }
}
