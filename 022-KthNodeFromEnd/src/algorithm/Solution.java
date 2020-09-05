package algorithm;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

class KthNodeFromEnd {

    ListNode FindKthToTail(ListNode head, int k) {
        ListNode node = head;
        for (int i = 0; i < k; i++) {
            node = node.next;
        }
        while (node != null) {
            head = head.next;
            node = node.next;
        }
        return head;
    }

}

public class Solution {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        KthNodeFromEnd list = new KthNodeFromEnd();
        int k = 2;
        ListNode res = list.FindKthToTail(node1, k);
        System.out.println("倒数第" + k + "个节点值为:" + res.val);
    }
}
