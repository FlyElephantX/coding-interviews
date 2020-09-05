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

}

public class Solution {

    public static void main(String[] args) {
        ReorderArray order = new ReorderArray();
        int[] arr = {1,2,3,4,5};
        order.reorderOddEvent(arr);
    }
}
