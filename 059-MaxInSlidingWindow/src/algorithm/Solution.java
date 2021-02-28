package algorithm;

import java.util.*;

class  MaxQueue {

    Queue<Integer> queue;
    LinkedList<Integer> max;

    public MaxQueue() {
        queue = new LinkedList<>();
        max = new LinkedList<>();
    }

    public int max_value() {
        return max.size() == 0 ? - 1 : max.getFirst();
    }

    public void push_back(int value) {
        queue.add(value);
        while (max.size() != 0 && max.getLast() < value) {
            max.removeLast();
        }
        max.add(value);
    }

    public int pop_front() {
        if (max.size() != 0 && queue.peek().equals(max.getFirst())) {
            max.removeFirst();
        }
        return queue.size() == 0 ? -1 : queue.poll();
    }
}

class MaxInSlidingWindow {

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (num.length >= size && size >= 1) {
            LinkedList<Integer> max = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                while (!max.isEmpty() && num[i] >= num[max.getLast()]) {
                    max.removeLast();
                }
                max.add(i);
            }
            for (int i = size; i < num.length; i++) {
                res.add(num[max.getFirst()]);
                while (!max.isEmpty() && num[i] >= num[max.getLast()]) {
                    max.removeLast();
                }
                if (!max.isEmpty() && max.getFirst() <= (i - size)) {
                    max.removeFirst();
                }
                max.add(i);
            }
            res.add(num[max.getFirst()]);
        }
        return res;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            if (i > 0 && deque.peekFirst() == nums[i - 1]) { // 降序数组每轮窗口滑动都会进行该条件
                deque.removeFirst();// 删除 deque 中对应的 nums[i-1]
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[j]) {
                deque.removeLast();// 保持 deque 递减
            }
            deque.addLast(nums[j]);
            if (i >= 0) {
                res[i] = deque.peekFirst();// 记录窗口最大值
            }
        }
        return res;
    }
}

public class Solution {

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 2, 6, 2, 5, 1};
        MaxInSlidingWindow window = new MaxInSlidingWindow();
        ArrayList<Integer> res = window.maxInWindows(nums, 3);
        System.out.println("滑动窗口的最大值:" + res);
        int[] nums1 = {6, 5, 4, 3, 2, 1};
        int[] res1 = window.maxSlidingWindow(nums1, 3);
        System.out.println("滑动窗口的最大值:" + Arrays.toString(res1));
    }
}
