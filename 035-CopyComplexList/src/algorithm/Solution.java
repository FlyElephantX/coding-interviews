package algorithm;

import java.util.HashMap;

class ComplexListNode {
    String value;
    ComplexListNode next;
    ComplexListNode random;

    public ComplexListNode(String value) {
        this.value = value;
    }
}

class CopyComplexList {

    public ComplexListNode clone(ComplexListNode head) {
        HashMap<ComplexListNode, ComplexListNode> hashMap = new HashMap<>();
        ComplexListNode cur = head;
        while (cur != null) {
            hashMap.put(cur, new ComplexListNode(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            ComplexListNode current = hashMap.get(cur);
            current.next = hashMap.get(cur.next);
            current.random = hashMap.get(cur.random);
            cur = cur.next;
        }
        return hashMap.get(head);
    }

    public void printComplexList(ComplexListNode head) {
        while (head != null) {
            String random = head.random == null ? "" : head.random.value;
            System.out.println(head.value + "--" + random);
            head = head.next;
        }
    }
}

public class Solution {

    public static void main(String[] args) {
        ComplexListNode node1 = new ComplexListNode("A");
        ComplexListNode node2 = new ComplexListNode("B");
        ComplexListNode node3 = new ComplexListNode("C");
        ComplexListNode node4 = new ComplexListNode("D");
        ComplexListNode node5 = new ComplexListNode("E");
        node1.next = node2;
        node1.random = node3;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node4.random = node2;
        CopyComplexList copy = new CopyComplexList();
        copy.printComplexList(node1);
        ComplexListNode head = copy.clone(node1);
        copy.printComplexList(head);
    }

}
