package algorithm;

import java.util.Stack;

class MinInStack {

    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(Integer val) {
        dataStack.push(val);
        if (minStack.empty() || val < minStack.peek()) {
            minStack.push(val);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public Integer min() {
        return dataStack.peek();
    }

    public Integer top() {
        return dataStack.peek();
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }
}


public class Solution {

    public static void main(String[] args) {
        MinInStack minStack = new MinInStack();
        minStack.push(3);
        minStack.push(4);
        minStack.push(2);
        minStack.push(1);
        System.out.println("最小值:" + minStack.min());
        minStack.pop();
        minStack.pop();
        minStack.push(0);
        System.out.println("最小值:" + minStack.min());
    }
}
