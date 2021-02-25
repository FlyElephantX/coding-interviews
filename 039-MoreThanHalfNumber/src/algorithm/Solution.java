package algorithm;

class MoreThanHalfNumber {

    public int moreThanHalfNum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int num = nums[0];
        int count = 0;
        for (int i = 0;i < nums.length; i++) {
            if (count == 0) {
                num = nums[i];
                count = 1;
            } else {
                if (nums[i] == num) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                k++;
            }
        }

        return k > nums.length / 2 ? num : -1;
    }

    public int majorityElement(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int pre = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if (cur == pre) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    pre = cur;
                    count = 1;
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == pre) {
                cnt++;
            }
        }
        return cnt > nums.length / 2 ? pre : -1;
    }

}

public class Solution {

    public static void main(String[] args) {
        MoreThanHalfNumber halfNumber = new MoreThanHalfNumber();
        int[] nums = {1,2,3,2,2,2,5,4,2};
        int res = halfNumber.moreThanHalfNum(nums);
        System.out.println("数组中出现次数超过一半的数字:" + res);
        int[] nums1 = {10,9,9,9,10};
        int res1 = halfNumber.majorityElement(nums1);
        System.out.println("数组中出现次数超过一半的数字:" + res1);
    }
}
