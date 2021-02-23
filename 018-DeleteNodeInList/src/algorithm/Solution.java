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

    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode node = head;
        while (node != null) {
            if (node.val == val) {
                if (node.next == null) {
                    ListNode tmp = head;
                    while (tmp.next != null && tmp.next.val != val) {
                        tmp = tmp.next;
                    }
                    tmp.next = null;
                } else {
                    node.val = node.next.val;
                    node.next = node.next.next;
                }
                break;
            }
            node = node.next;
        }
        return head;
    }

    public ListNode deleteNode1(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode cur = head;
        while (cur.next != null && cur.next.val != val) {
            cur = cur.next;
        }
        if (cur.next != null) { // 删除的val不存在链表中会出现cur.next = null
            cur.next = cur.next.next;
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
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        DeleteNodeInList list = new DeleteNodeInList();
//        list.deleteNode(node1, node4);
//        list.printNodeList(node1);
        ListNode cur = list.deleteNode1(node1, 30);
        list.printNodeList(cur);
    }
}
