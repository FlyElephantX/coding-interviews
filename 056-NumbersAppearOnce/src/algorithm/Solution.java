package algorithm;

import java.util.Arrays;

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

    public int[] singleNumbers(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num = num ^ nums[i];
        }
        int bit = 1;
        while ((num & bit) == 0) {
            bit = bit << 1;
        }
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & bit) != 0) {
                num1 = num1 ^ nums[i];
            } else {
                num2 = num2 ^ nums[i];
            }
        }
        return new int[]{num1, num2};
    }

    public int singleNumber1(int[] nums) {
        int[] counts = new int[32];
        for (int num : nums) {
            for (int j = 0; j < 32; j++) {// 从低位到高位进行存储
                int val = num & 1;
                counts[j] = counts[j] + val;
                num = num >>> 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) { // 从高位到低位进行计算
            res = res << 1;
            res = res + counts[31 - i] % 3;
        }
        return res;
    }

}


public class Solution {

    public static void main(String[] args) {
        NumbersAppearOnce number = new NumbersAppearOnce();
        int[] nums = {2, 4, 3, 6, 3, 2, 5, 5};
        number.findNumsAppearOnce(nums);
        int[] nums2 =  number.singleNumbers(nums);
        System.out.println("数组中出现1次的数字:" + Arrays.toString(nums2));
        int[] nums1 = {3, 4, 3, 3};
        int res =  number.singleNumber1(nums1);
        System.out.println("数组出现1次的数字:" + res);
    }
}
