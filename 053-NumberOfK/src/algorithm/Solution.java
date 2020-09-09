package algorithm;

import javax.swing.plaf.IconUIResource;

class NumberOfK {

    public int getNumberOfK(int [] nums , int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        int first = getFirstK(nums, k);
        int last = getLastK(nums, k);
        if (first != -1 && last != -1) {
            count = last - first + 1;
        }
        return count;
    }

    public int getFirstK(int[] nums, int k)  {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int middleData = nums[mid];
            if (middleData == k) {
                if (mid - 1 >= 0 && nums[mid - 1] == k) {
                    end = mid - 1;
                } else {
                    return mid;
                }
            } else if (middleData > k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public int getLastK(int[] nums, int k)  {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int middleData = nums[mid];
            if (middleData == k) {
                if (mid + 1 < nums.length && nums[mid + 1] == k) {
                    start = mid + 1;
                } else {
                    return mid;
                }
            } else if (middleData > k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }


}

public class Solution {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3, 3, 4, 5};
        NumberOfK number = new NumberOfK();
        int count = number.getNumberOfK(nums, 3);
        System.out.println("出现的次数:" + count);
    }
}
