package algorithm;

import javax.swing.plaf.IconUIResource;
import java.util.HashMap;
import java.util.Map;

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

    public int search(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int val = 1;
            if (map.containsKey(nums[i])) {
                val = map.get(cur) + 1;
            }
            map.put(cur, val);
        }
        return map.getOrDefault(target, -1);
    }

    public int search1(int[] nums, int target) {
        // 搜索右边界 right
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        int right = i;
        // 若数组中无 target ，则提前返回
        if(j >= 0 && nums[j] != target) return 0;
        // 搜索左边界 right
        i = 0; j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] < target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        int left = j;
        return right - left - 1;
    }

    public int search2(int[] nums, int target) { // 直接将题目难度降低到普通模式
        return helper(nums, target) - helper(nums, target - 1);
    }

    int helper(int[] nums, int tar) { // 返回的是右边界
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= tar) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }

}

public class Solution {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3, 3, 4, 5};
        NumberOfK number = new NumberOfK();
        int count = number.getNumberOfK(nums, 3);
        System.out.println("出现的次数:" + count);
        int count1 = number.search(nums, 3);
        System.out.println("出现的次数:" + count1);
    }
}
