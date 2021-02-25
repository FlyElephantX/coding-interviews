package algorithm;


class BinaryTreeNode {
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(int val) {
        this.val = val;
    }
}

class SubstructureInTree {

    public boolean hasSubTree(BinaryTreeNode root1, BinaryTreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                result = doesTreeHaveTree(root1, root2);
            }
            if (!result) {
                result = hasSubTree(root1.left, root2);
            }
            if (!result) {
                result = hasSubTree(root1.right, root2);
            }
        }
        return result;
    }

    public boolean doesTreeHaveTree(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null || root1.val != root2.val) {
            return false;
        }
        return doesTreeHaveTree(root1.left, root2.left) && doesTreeHaveTree(root1.right, root2.right);
    }

}

public class Solution {

    public static void main(String[] args) {
        BinaryTreeNode node1 = new BinaryTreeNode(8);
        BinaryTreeNode node2 = new BinaryTreeNode(8);
        BinaryTreeNode node3 = new BinaryTreeNode(7);
        BinaryTreeNode node4 = new BinaryTreeNode(9);
        BinaryTreeNode node5 = new BinaryTreeNode(2);
        BinaryTreeNode node6 = new BinaryTreeNode(4);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.left = node6;
        node6.right = node7;
        BinaryTreeNode n1 = new BinaryTreeNode(8);
        BinaryTreeNode n2 = new BinaryTreeNode(9);
        BinaryTreeNode n3 = new BinaryTreeNode(2);
        n1.left = n2;
        n1.right = n3;
        SubstructureInTree tree = new SubstructureInTree();
        boolean res = tree.hasSubTree(node1, n1);
        if (res) {
            System.out.println("存在子结构");
        } else {
            System.out.println("不存在子结构");
        }
    }
}
