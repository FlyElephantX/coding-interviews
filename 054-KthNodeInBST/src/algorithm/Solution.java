package algorithm;

import java.util.function.IntUnaryOperator;

class BinaryTreeNode {
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(int val) {
        this.val = val;
    }
}

class KthNodeInBST {

    private int k = 0;
    private BinaryTreeNode res;
    private int index = 0;

    public BinaryTreeNode kthNode(BinaryTreeNode root, int k) {
        if (root == null) {
            return null;
        }
        if (k == 0) {
            return root;
        }
        this.k = k;
        inOrder(root);
        return res;
    }

    private void inOrder(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (k == 0) {
            return;
        }
        if (k == 1) {
            res = root;
        }
        k--;
        inOrder(root.right);
    }

    public BinaryTreeNode kthNode1(BinaryTreeNode root, int k) {
        if (root == null) {
            return null;
        }
        BinaryTreeNode node = kthNode1(root.left, k);
        if (node != null) {
            return node;
        }
        index++;
        if (index == k) {
            return root;
        }
        node = kthNode1(root.right, k);
        if (node != null) {
            return node;
        }
        return null;
    }

}

public class Solution {

    public static void main(String[] args) {
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(3);
        BinaryTreeNode node3 = new BinaryTreeNode(7);
        BinaryTreeNode node4 = new BinaryTreeNode(2);
        BinaryTreeNode node5 = new BinaryTreeNode(4);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node7 = new BinaryTreeNode(8);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        KthNodeInBST bst = new KthNodeInBST();
        int k = 5;
        BinaryTreeNode node = bst.kthNode(node1, k);
        System.out.println("第" + k +"个节点的值:" + node.val);
    }
}
