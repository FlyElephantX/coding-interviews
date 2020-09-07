package algorithm;

import java.util.PriorityQueue;

class StreamMedian {

    // 大顶堆
    private PriorityQueue<Integer> left = new PriorityQueue<>((x, y) -> y - x);
    private PriorityQueue<Integer> right = new PriorityQueue<>();

    public void insert(Integer num) {
        if (left.size() != right.size()) {// 奇数
            right.add(num);
            left.add(right.poll());// 确保大顶堆中的值小于小顶堆中的值
        } else { // 偶数
            left.add(num);
            right.add(left.poll());// 确保小顶堆中的值大于大顶堆中的所有值
        }
    }

    public double getMedian() {
        if (left.size() != right.size()) {
            return right.peek();
        } else {
            return (left.peek() + right.peek()) / 2.0;
        }
    }

}

public class Solution {

    public static void main(String[] args) {
        StreamMedian median = new StreamMedian();
        int[] nums = {5, 2, 4, 3, 1, 6};
        for (int i = 0; i < nums.length; i++) {
            median.insert(nums[i]);
        }
        double res = median.getMedian();
        System.out.println("数组中的中位数:" + res);
    }
}
