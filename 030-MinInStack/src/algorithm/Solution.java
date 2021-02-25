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

class MinStack1 {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public MinStack1() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        if (s2.isEmpty() ||  x <= s2.peek()) {
            s2.push(x);
        }
        s1.push(x);
    }

    public void pop() {
        int top = s1.pop();
        if (top == s2.peek()) {
            s2.pop();
        }
    }

    public int top() {
        return s1.peek();
    }

    public int min() {
        return s2.peek();
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

        MinStack1 minStack1 = new MinStack1();
        minStack1.push(-2);
        minStack1.push(0);
        minStack1.push(-1);
        int min = minStack1.min();
        System.out.println("最小值:" + min);
    }
}
