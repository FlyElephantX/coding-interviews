package algorithm;

import java.util.LinkedList;
import java.util.List;

class ListNode {
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
    }
}

class FirstCommonNodesInLists {

    public ListNode findFirstCommonNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        int len1 = getLinkedListLength(head1);
        int len2 = getLinkedListLength(head2);
        int steps = Math.abs(len1 - len2);
        if (len1 > len2) {
            head1 = linkListStep(head1, steps);
        } else {
            head2 = linkListStep(head2, steps);
        }
        while (head1 != null && head2 != null) {
            if (head1.value == head2.value) {
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return null;
    }

    public ListNode linkListStep(ListNode head, int steps) {
        int i = 0;
        while (i < steps) {
            head = head.next;
            i++;
        }
        return head;
    }

    public int getLinkedListLength(ListNode head) {
        if (head == null) {
            return 0;
        }
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    // A链表总长度为LA + C，B链表总长度为LB + C。
    //当指针按照题解方式走下去，p1第二次走到公共节点的时候，走过的长度为LA + C + LB，p2第二次走到公共节点的时候，走过的长度为LB + C + LA。p1 p2走过的长度相等，p1 p2 相遇。
    //所以，当p1 p2 相遇（相等）的时候，指向的节点就是公共节点。
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }
            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
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
        ListNode node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode n1 = new ListNode(8);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(6);
        ListNode n4 = new ListNode(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        FirstCommonNodesInLists list = new FirstCommonNodesInLists();
        ListNode res = list.findFirstCommonNode(node1, n1);
        if (res != null) {
            System.out.println("第一个公共节点:" + res.value);
        } else {
            System.out.println("无公共节点");
        }

    }
}
