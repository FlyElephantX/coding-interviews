package algorithm;

import java.util.List;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

class MergeSortedLists {

    ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode head = null;
        ListNode node = null;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                if (head == null) {
                    head = head1;
                    node = head;
                } else {
                    head.next = head1;
                    head = head.next;
                }
                head1 = head1.next;
            } else {
                if (head == null) {
                    head = head2;
                    node = head;
                } else {
                    head.next = head2;
                    head = head.next;
                }
                head2 = head2.next;
            }
        }
        if (head1 != null) {
            head.next = head1;
        }
        if (head2 != null) {
            head.next = head2;
        }
        return node;
    }

    public void printList(ListNode head) {
        if (head == null) {
            return;
        }
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

public class Solution {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(6);
        ListNode n4 = new ListNode(8);
        ListNode n5 = new ListNode(10);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        MergeSortedLists merge = new MergeSortedLists();
        ListNode head = merge.merge(node1, n1);
        merge.printList(head);
    }
}
