package algorithm;

import java.util.ArrayList;
import java.util.Stack;

class ListNode {
   int val;
   ListNode next = null;

   ListNode(int val) {
       this.val = val;
   }
 }

class PrintListInReversedOrder {

    public void printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public void printListFromTailToHead1(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead(listNode.next);
            System.out.println(listNode.val);
        }
    }

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int size = stack.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = stack.pop();
        }
        return res;
    }
}

public class Solution {

    public static void main(String[] args) {
        PrintListInReversedOrder order = new PrintListInReversedOrder();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        order.printListFromTailToHead(node1);
    }
}
