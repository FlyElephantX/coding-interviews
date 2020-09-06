package algorithm;

import java.util.Arrays;

class KLeastNumbers {

    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr, 0, k);
    }
}

public class Solution {

    public static void main(String[] args) {
        KLeastNumbers numbers = new KLeastNumbers();
        int[] nums = {1, 3, 5, 7, 9, 2, 4, 6, 8, 10};
        int[] res = numbers.getLeastNumbers(nums, 3);
        System.out.println(Arrays.toString(res));
    }
}
