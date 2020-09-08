package algorithm;

class UglyNumber {

    public int getUglyNumber(int index) {
        if (index <= 0) {
            return 0;
        }
        int[] nums = new int[index];
        nums[0] = 1;
        int count = 1;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        while (count < index) {
            int min = Math.min(nums[i2] * 2, Math.min(nums[i3] * 3, nums[i5] * 5));
            nums[count] = min;
            if (nums[i2] * 2 == min) {
                i2++;
            }
            if (nums[i3] * 3 == min) {
                i3++;
            }
            if (nums[i5] * 5 == min) {
                i5++;
            }
            count++;
        }
        return nums[index - 1];
    }

}

public class Solution {

    public static void main(String[] args) {
        UglyNumber number = new UglyNumber();
        for (int i = 1; i <= 10; i++) {
            int min = number.getUglyNumber(i);
            System.out.println("丑数:" + min);
        }
    }
}
