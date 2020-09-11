package algorithm;

import java.util.Arrays;
import java.util.HashMap;

class TwoNumbersWithSum {

    public int[] findNumbersWithSum(int[] nums, int sum) {
        int[] res = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], 1);
        }
        for (int i = 0; i < nums.length; i++) {
            int num = sum - nums[i];
            if (map.containsKey(num)) {
                res[0] = nums[i];
                res[1] = num;
                break;
            }
        }
        return res;
    }

    public void findContinuousSequence(int sum) {
        if (sum < 3) {
            return;
        }
        int start = 1;
        int end = 2;
        int middle = (sum + 1) / 2;
        int curSum = start + end;
        while (start < middle) {
            if (curSum == sum) {
                printContinuousSequence(start, end);
            }
            while (curSum > sum && start < middle) {
                curSum = curSum - start;
                start++;
                if (curSum == sum) {
                    printContinuousSequence(start, end);
                }
            }
            end++;
            curSum = curSum + end;
        }
    }


    public void printContinuousSequence(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
    }
}

public class Solution {

    public static void main(String[] args) {
        int[] nums = {1,2,4,7,11,15};
        TwoNumbersWithSum sum = new TwoNumbersWithSum();
        int[] res = sum.findNumbersWithSum(nums, 15);
        System.out.println("最终展示的结果:" + Arrays.toString(res));
        sum.findContinuousSequence(15);
    }
}
