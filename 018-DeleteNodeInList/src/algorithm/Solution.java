package algorithm;

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}

class DeleteNodeInList {

    public void deleteNode(ListNode head, ListNode toBeDeleted) {
        if (head == null || toBeDeleted == null) {
            return;
        }
        if (toBeDeleted.next != null) {
            int val = toBeDeleted.next.val;
            ListNode next = toBeDeleted.next.next;
            toBeDeleted.val = val;
            toBeDeleted.next = next;
        } else {
            ListNode cur = head;
            while (cur.next != toBeDeleted) {
                cur = cur.next;
            }
            cur.next = null;
        }
    }

    public void printNodeList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

public class Solution {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        DeleteNodeInList list = new DeleteNodeInList();
        list.deleteNode(node1, node4);
        list.printNodeList(node1);
    }
}
