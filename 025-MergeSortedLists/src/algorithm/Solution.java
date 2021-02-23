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
        if (head1.val < head2.val) {
            head = head1;
            head1 = head1.next;
        } else {
            head = head2;
            head2 = head2.next;
        }
        ListNode node = head;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                node.next = head1;
                head1 = head1.next;
            } else {
                node.next = head2;
                head2 = head2.next;
            }
            node = node.next;
        }
        if (head1 != null) {
            node.next = head1;
        }
        if (head2 != null) {
            node.next = head2;
        }
        return head;
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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = null;
        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return head;
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
