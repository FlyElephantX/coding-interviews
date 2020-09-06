package algorithm;

import java.util.Arrays;

class BinaryTreeNode {
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(int val) {
        this.val = val;
    }
}

class SequenceOfBST {

    public boolean verifySequenceOfBST(int [] sequence) {
        return recur(sequence, 0, sequence.length - 1);
    }

    public boolean recur(int[] postOrder, int i, int j) {
        if (i >= j) {
            return true;
        }
        int p = i;
        while (postOrder[p] < postOrder[j]) { // 左子树
            p++;
        }
        int m = p;
        while (postOrder[p] > postOrder[j]) { // 右子树
            p++;
        }
        return p == j && recur(postOrder, i, m - 1) && recur(postOrder, m, j - 1);
    }
}

public class Solution {

    public static void main(String[] args) {
        int[] data = {5,7,6,9,11,10,8};
        SequenceOfBST sequence = new SequenceOfBST();
        boolean res = sequence.verifySequenceOfBST(data);
        if (res) {
            System.out.println(Arrays.toString(data) + "是二叉搜索树的后序遍历序列");
        } else {
            System.out.println(Arrays.toString(data) + "不是二叉搜索树的后序遍历序列");
        }
    }
}
