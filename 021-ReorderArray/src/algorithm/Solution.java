package algorithm;

import java.util.Arrays;

class ReorderArray {

    public void reorderOddEvent(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            if (arr[low] % 2 == 0) {
                swap(arr, low, high);
                high--;
            } else {
                low++;
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
