package algorithm;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

class EntryNodeInListLoop {

    public ListNode entryNodeOfLoop(ListNode head) {
        ListNode node = meetingNode(head);
        if (node == null) {
            return null;
        }
        ListNode begin = node.next;
        int count = 1;
        while (begin != node) {
            count++;
            begin = begin.next;
        }
        ListNode start = head;
        for (int i = 0; i < count; i++) {
            start = start.next;
        }
        while (start != head) {
            head = head.next;
            start = start.next;
        }
        return start;
    }

    // 判断链表中是否存在环
    public ListNode meetingNode(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (slow != fast && fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                fast = null;
            }
        }
        return fast;
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
        node6.next = node3;
        EntryNodeInListLoop loop = new EntryNodeInListLoop();
        ListNode res = loop.entryNodeOfLoop(node1);
        if (res != null) {
            System.out.println("环的入口节点:" + res.val);
        } else {
            System.out.println("环中不存在节点");
        }
    }
}
