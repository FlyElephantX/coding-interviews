package algorithm;

 class TreeLinkNode {
   String val;
   TreeLinkNode left = null;
   TreeLinkNode right = null;
   // 父节点
   TreeLinkNode parent = null;

   TreeLinkNode(String val) {
       this.val = val;
   }

   public void config(TreeLinkNode parent, TreeLinkNode left, TreeLinkNode right) {
       this.parent = parent;
       this.left = left;
       this.right = right;
   }
}

class NextNodeInBinaryTrees {

     public TreeLinkNode GetNext(TreeLinkNode pNode) {
         if (pNode == null) {
             return null;
         }
         if (pNode.right != null) {// 右子树非空
             TreeLinkNode node = pNode.right;
             while (node.left != null) {
                 node = node.left;
             }
             return node;
         }
         while (pNode.parent != null) {
             if (pNode == pNode.parent.left) {
                 return pNode.parent;
             }
             pNode = pNode.parent;
         }
         return null;
     }
}

public class Solution {

    public static void main(String[] args) {
        TreeLinkNode l1 = new TreeLinkNode("a");
        TreeLinkNode l2 = new TreeLinkNode("b");
        TreeLinkNode l3 = new TreeLinkNode("c");
        TreeLinkNode l4 = new TreeLinkNode("d");
        TreeLinkNode l5 = new TreeLinkNode("e");
        TreeLinkNode l6 = new TreeLinkNode("f");
        TreeLinkNode l7 = new TreeLinkNode("g");
        TreeLinkNode l8 = new TreeLinkNode("h");
        TreeLinkNode l9 = new TreeLinkNode("i");
        l1.config(null, l2, l3);
        l2.config(l1, l4, l5);
        l3.config(l1, l6, l7);
        l4.config(l2, null, null);
        l5.config(l2, l8, l9);
        l6.config(l3, null, null);
        l7.config(l3, null, null);
        l8.config(l5, null, null);
        l9.config(l5, null, null);
        NextNodeInBinaryTrees trees = new NextNodeInBinaryTrees();
        TreeLinkNode node = trees.GetNext(l9);
        System.out.println(node.val);
    }
}
