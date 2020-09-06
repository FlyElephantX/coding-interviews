package algorithm;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.List;

class BinaryTreeNode {
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(int val) {
        this.val = val;
    }
}

class PathInTree {

    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(BinaryTreeNode root, int sum) {
        recur(root, sum);
        return res;
    }

    public void recur(BinaryTreeNode root, int target) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        target = target - root.val;
        if (target == 0 && root.left == null && root.right == null) {
            res.add(new LinkedList(path));
        }
        recur(root.left, target);
        recur(root.right, target);
        path.removeLast();
    }
}

public class Solution {

    public static void main(String[] args) {
        PathInTree tree = new PathInTree();
        BinaryTreeNode node1 = new BinaryTreeNode(10);
        BinaryTreeNode node2 = new BinaryTreeNode(5);
        BinaryTreeNode node3 = new BinaryTreeNode(12);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        List<List<Integer>> res = tree.pathSum(node1, 22);
        System.out.println("所有符合的路径:" + res);
    }
}
