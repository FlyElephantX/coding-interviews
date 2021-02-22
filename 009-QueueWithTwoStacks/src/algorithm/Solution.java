package algorithm;

import java.util.Queue;
import java.util.Stack;

class QueueWithTwoStacks {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void offer(Integer val) {
        s1.push(val);
    }

    public Integer poll() {
        if (s1.size() == 0 && s2.size() == 0) {
            try {
                throw new Exception("empty queue");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            if (s2.size() == 0) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.pop();
        }

        return s2.peek();
    }

    public Integer poll1() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.isEmpty() ? -1 : s2.pop();
    }
}

public class Solution {

    public static void main(String[] args) {
        QueueWithTwoStacks queue = new QueueWithTwoStacks();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.poll1());
        System.out.println(queue.poll1());
        System.out.println(queue.poll1());
        System.out.println(queue.poll1());
    }
}
