package algorithm;

class InversePairs {

    public int inversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public int inversePairs1(int [] array) {
        int count = 0;
        if (array == null || array.length == 0) {
            return count;
        }
        count = mergeSort(array, 0, array.length - 1);
        return count;
    }

    public int mergeSort(int[] array, int low, int high) {
        int count = 0;
        if (low >= high) {
            return count;
        }
        int mid = (low + high) >> 1;
        // 辅助数组
        int[] temp = new int[array.length];
        int left = mergeSort(array, low, mid);
        int right = mergeSort(array, mid + 1, high);
        count = left + right + merge(array, temp, low, mid, high);
        return count;
    }

    public int merge(int[] array, int[] temp, int low, int mid, int high) {
        int count = 0;
        // 代表左边最右端下标
        int i = mid;
        // 代表右边最右端下标
        int j = high;
        // 代表辅助数组最右端的下标
        int k = high;
        while (i >= low && j >= mid + 1) {
            if (array[i] > array[j]) {
                temp[k--] = array[i--];
                count += j - mid;
            } else {
                temp[k--] = array[j--];
            }
        }
        // 如果左边有剩余元素，移入辅助数组
        while (i >= low) {
            temp[k--] = array[i--];
        }
        // 如果右边有剩余元素，移入辅助数组
        while (j >= mid + 1) {
            temp[k--] = array[j--];
        }
        // 临时数组覆盖原数组
        System.arraycopy(temp, low, array, low, high - low + 1);
        return count;
    }

    public int inversePairs2(int [] array) {
        int count = 0;
        if (array == null || array.length == 0) {
            return count;
        }
        count = mergeSort1(array, 0, array.length - 1);
        return count;
    }

    public int mergeSort1(int[] array, int low, int high) {
        int count = 0;
        if (low >= high) {
            return count;
        }
        int mid = (low + high) >> 1;
        // 辅助数组
        int left = mergeSort1(array, low, mid);
        int right = mergeSort1(array, mid + 1, high);
        count = left + right + merge1(array, low, mid, high);
        return count;
    }

    public int merge1(int[] array, int low, int mid, int high) {
        int len = high - low + 1;
        int[] temp = new int[len];
        int count = 0;
        int left = low;
        int right = mid + 1;
        int i = 0;
        while (left <= mid && right <= high) {
            if (array[left] <= array[right]) {
                temp[i++] = array[left++];
            } else {
                temp[i++] = array[right++];
                count += (mid - left + 1);
            }
        }
        while (left <= mid) {
            temp[i++] = array[left++];
        }
        while (right <= high) {
            temp[i++] = array[right++];
        }
        for (int j = 0; j < len; j++) {
            array[low + j] = temp[j];
        }
        return count;
    }
}

public class Solution {

    public static void main(String[] args) {
        int[] nums = {7, 5, 6, 4};
        InversePairs pairs = new InversePairs();
        int count = pairs.inversePairs1(nums);
        System.out.println("逆序对总数:" + count);
        int[] nums2 = {7, 5, 6, 4};
        int count1 = pairs.inversePairs2(nums2);
        System.out.println("逆序对总数:" + count1);
        int[] nums3 = {7, 5, 6, 4};
        int count2 = pairs.reversePairs(nums3);
        System.out.println("逆序对总数:" + count2);
    }
}
