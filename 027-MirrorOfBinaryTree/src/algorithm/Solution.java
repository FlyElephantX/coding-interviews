package algorithm;

class BinaryTreeNode {
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(int val) {
        this.val = val;
    }
}

class MirrorOfBinaryTree {

    public void mirrorTree(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        BinaryTreeNode leftNode = root.left;
        root.left = root.right;
        root.right = leftNode;
        if (root.left != null) {
            mirrorTree(root.left);
        }
        if (root.right != null) {
            mirrorTree(root.right);
        }
    }

    public void printTree(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        printTree(root.left);
        System.out.println(root.val);
        printTree(root.right);
    }

}

public class Solution {

    public static void main(String[] args) {
        BinaryTreeNode n1 = new BinaryTreeNode(8);
        BinaryTreeNode n2 = new BinaryTreeNode(6);
        BinaryTreeNode n3 = new BinaryTreeNode(10);
        BinaryTreeNode n4 = new BinaryTreeNode(5);
        BinaryTreeNode n5 = new BinaryTreeNode(7);
        BinaryTreeNode n6 = new BinaryTreeNode(9);
        BinaryTreeNode n7 = new BinaryTreeNode(11);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        MirrorOfBinaryTree tree = new MirrorOfBinaryTree();
        tree.mirrorTree(n1);
        tree.printTree(n1);
    }
}
