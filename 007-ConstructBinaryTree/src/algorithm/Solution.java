package algorithm;

/*
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
则重建二叉树并返回。
 */

class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;
   TreeNode(int x) { val = x; }
 }

 class ConstructBinaryTree {

    public void printTree(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            printTree(root.left);
            printTree(root.right);
        }
    }

     public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
         if (pre.length == 0 || in.length == 0) {
             return null;
         }
         return construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
     }

     public TreeNode construct(int[] pre, int ps, int pe, int[] in, int is, int ie) {
         if (ps > pe) {
             return null;
         }
         int root = pre[ps];
         TreeNode node = new TreeNode(root);
         int index = is;
         for (int i = is; i <= ie; i++) {
             if (in[i] == root) {
                 index = i;
                 break;
             }
         }
         int left = index - is;
         node.left = construct(pre, ps + 1 , ps + left, in, is, index - 1);
         node.right = construct(pre, ps + left + 1, pe, in, index + 1, ie);
         return node;
     }
 }



public class Solution {

    public static void main(String[] args) {
        ConstructBinaryTree binaryTree = new ConstructBinaryTree();
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode root = binaryTree.reConstructBinaryTree(pre, in);
        binaryTree.printTree(root);
    }
}
