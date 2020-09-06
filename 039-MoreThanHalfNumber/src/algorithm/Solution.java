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

}

public class Solution {

    public static void main(String[] args) {
        MoreThanHalfNumber halfNumber = new MoreThanHalfNumber();
        int[] nums = {1,2,3,2,2,2,5,4,2};
        int res = halfNumber.moreThanHalfNum(nums);
        System.out.println("数组中出现次数超过一半的数字:" + res);
    }
}
