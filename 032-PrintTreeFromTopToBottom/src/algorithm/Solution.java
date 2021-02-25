package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class BinaryTreeNode {
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(int val) {
        this.val = val;
    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

class PrintTreeFromTopToBottom {

    public void levelOrder(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode top = queue.poll();
            System.out.print(top.val + " ");
            if (top.left != null) {
                queue.add(top.left);
            }
            if (top.right != null) {
                queue.add(top.right);
            }
        }
    }

    public void levelOrder2(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                BinaryTreeNode top = queue.poll();
                sb.append(top.val + " ");
                if (top.left != null) {
                    queue.add(top.left);
                }
                if (top.right != null) {
                    queue.add(top.right);
                }
            }
            System.out.println(sb);
        }
    }

    public void levelOrder3(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                BinaryTreeNode top = queue.poll();
                if (level % 2 == 0){
                    sb.append(top.val + " ");
                } else {
                    sb.insert(0, top.val + " ");
                }
                if (top.left != null) {
                    queue.add(top.left);
                }
                if (top.right != null) {
                    queue.add(top.right);
                }
            }
            level++;
            System.out.println(sb);
        }
    }

    public int[] levelOrder4(BinaryTreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}

public class Solution {

    public static void main(String[] args) {
        BinaryTreeNode node1 = new BinaryTreeNode(8);
        BinaryTreeNode node2 = new BinaryTreeNode(6);
        BinaryTreeNode node3 = new BinaryTreeNode(10);
        BinaryTreeNode node4 = new BinaryTreeNode(5);
        BinaryTreeNode node5 = new BinaryTreeNode(7);
        BinaryTreeNode node6 = new BinaryTreeNode(9);
        BinaryTreeNode node7 = new BinaryTreeNode(11);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        PrintTreeFromTopToBottom tree = new PrintTreeFromTopToBottom();
        tree.levelOrder3(node1);
        int[] res = tree.levelOrder4(node1);
        System.out.println("最终结果:" + Arrays.toString(res));
        LinkedList<Integer> tmp = new LinkedList<>();
        tmp.add(10);
        tmp.addFirst(1);
        tmp.addLast(2);
        System.out.println(tmp);
    }
}
