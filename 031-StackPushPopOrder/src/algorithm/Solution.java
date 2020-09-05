package algorithm;

import java.util.Stack;

class StackPushPopOrder {

    public boolean isPopOrder(int[] pushed, int[] poped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == poped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}

public class Solution {

    public static void main(String[] args) {
        StackPushPopOrder popOrder = new StackPushPopOrder();
        int[] pushed = {1,2,3,4,5};
        int[] poped = {4,3,5,2,1};
        boolean res = popOrder.isPopOrder(pushed, poped);
        if (res) {
            System.out.println("是栈序列的弹出序列");
        } else {
            System.out.println("不是栈序列的弹出序列");
        }
    }
}
