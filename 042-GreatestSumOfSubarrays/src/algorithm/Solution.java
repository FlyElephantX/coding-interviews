package algorithm;

class GreatestSumOfSubarrays {

    public int findGreatestSumOfSubArray(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int sum = nums[0];
        int max = sum;
        for (int i = 1; i < nums.length; i++) {
            if (sum <= 0) {
                sum = nums[i];
            } else {
                sum = sum + nums[i];
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}

public class Solution {

    public static void main(String[] args) {
        GreatestSumOfSubarrays sum = new GreatestSumOfSubarrays();
        int[] nums = {1, -2, 3, 10, -4, 7, 2, -5};
        int res = sum.findGreatestSumOfSubArray(nums);
        System.out.println("连续子数组的最大和:" + res);
        int[] nums1 = {-1};
        int res1 = sum.findGreatestSumOfSubArray(nums1);
        System.out.println("连续子数组的最大和:" + res1);
    }
}
