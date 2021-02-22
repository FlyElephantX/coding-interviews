package algorithm;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，
 * 我们称之为数组的旋转。输入一个递增排序的数组
 * 的一个旋转，输出旋转数组的最小元素。例如数组
 * {3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 */


class MinNumberInRotatedArray {

    public int min(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while (low < high) {
            mid = (low + high) / 2;
            if (arr[low] == arr[high] && arr[mid] == arr[low])
                return findMin(arr, low, high);
            if (high - low == 1) {
                mid = high;
                break;
            }
            if (arr[mid] > arr[low]) {
                low = mid;
            } else if (arr[mid] < arr[high]) {
                high = mid;
            }

        }
        return arr[mid];
    }

    public int findMin(int[] arr, int low, int high) {
        int min = arr[low];
        for (int i = low; i <= high; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public int minArray(int[] numbers) {
        if (numbers.length == 0) {
            return -1;
        }
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int privot = low + (high - low) / 2;
            if (numbers[privot] < numbers[high]) {
                high = privot;
            } else if (numbers[privot] > numbers[high]) {
                low = privot + 1;
            } else {
                high = high - 1;
            }
        }
        return numbers[low];
    }

}

public class Solution {

    public static void main(String[] args) {
        MinNumberInRotatedArray roate = new MinNumberInRotatedArray();
        int[] arr = {1,0,1,1,1};
        int val1 = roate.min(arr);
        System.out.println("最小值:" + val1);
        int val2 = roate.minArray(arr);
        System.out.println("最小值:" + val2);
    }
}
