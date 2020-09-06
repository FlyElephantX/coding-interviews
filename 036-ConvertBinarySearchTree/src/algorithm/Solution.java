package algorithm;

class BinaryTreeNode {
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(int val) {
        this.val = val;
    }
}


class ConvertBinarySearchTree {

    BinaryTreeNode head,pre;

    public BinaryTreeNode convert(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        inOrder(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void inOrder(BinaryTreeNode cur) {
        if (cur == null) {
            return;
        }
        inOrder(cur.left);
        if (pre != null) {
            pre.right = cur;
        } else {
            head = cur;
        }
        pre = cur;
        inOrder(cur.right);
    }
}

public class Solution {

    public static void main(String[] args) {
        BinaryTreeNode node1 = new BinaryTreeNode(10);
        BinaryTreeNode node2 = new BinaryTreeNode(6);
        BinaryTreeNode node3 = new BinaryTreeNode(14);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(8);
        BinaryTreeNode node6 = new BinaryTreeNode(12);
        BinaryTreeNode node7 = new BinaryTreeNode(16);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        ConvertBinarySearchTree searchTree = new ConvertBinarySearchTree();
        BinaryTreeNode head = searchTree.convert(node1);
        BinaryTreeNode cur = head.right;
        System.out.println(head.val);
        while (cur != null && cur != head ) {
            System.out.println(cur.val);
            cur = cur.right;
        }
    }

}
