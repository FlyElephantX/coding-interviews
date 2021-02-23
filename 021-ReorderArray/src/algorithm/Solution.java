package algorithm;

import java.util.Arrays;

class ReorderArray {

    public void reorderOddEvent(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            while (low < high && arr[low] % 2 == 1) {
                low++;
            }
            while (low < high && arr[high] % 2 == 0) {
                high--;
            }
            if (low < high) {
                swap(arr, low, high);
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public void swap(int[] arr, int i, int j) {
        int val = arr[i];
        arr[i] = arr[j];
        arr[j] = val;
    }

    public int[] exchange(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            while (i <= j && nums[i] % 2 == 1) {
                i++;
            }
            while (i <= j && nums[j] % 2 == 0) {
                j--;
            }
            if (i <= j) {
                swap(nums, i, j);
            }
        }
        return nums;
    }

}

public class Solution {

    public static void main(String[] args) {
        ReorderArray order = new ReorderArray();
        int[] arr = {1,2,3,4,5};
        order.reorderOddEvent(arr);
        int[] arr1 = {1,3,5};
        int[] res = order.exchange(arr1);
        System.out.println(Arrays.toString(res));
    }
}
