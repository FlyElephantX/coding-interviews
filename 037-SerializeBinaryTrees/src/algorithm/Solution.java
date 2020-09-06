package algorithm;

class BinaryTreeNode {
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(int val) {
        this.val = val;
    }
}

class SerializeBinaryTrees {

    private int index;

    public String serialize(BinaryTreeNode root) {
        if (root == null) {
            return "$,";
        }
        return root.val + "," + serialize(root.left) + serialize(root.right);
    }

    public BinaryTreeNode deserialize(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        index = -1;
        String[] nodeList = str.split(",");
        return deserialize(nodeList);
    }

    private BinaryTreeNode deserialize(String[] nodeList) {
        index++;
        BinaryTreeNode head = null;
        if (!nodeList[index].equals("$")) {
            head = new BinaryTreeNode(Integer.valueOf(nodeList[index]));
            head.left = deserialize(nodeList);
            head.right = deserialize(nodeList);
        }
        return head;
    }
}

public class Solution {

    public static void main(String[] args) {
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        SerializeBinaryTrees serializeTree = new SerializeBinaryTrees();
        String str = serializeTree.serialize(node1);
        System.out.println("前序遍历字符串:" + str);
        BinaryTreeNode head = serializeTree.deserialize(str);
        String str2 = serializeTree.serialize(head);
        System.out.println("前序遍历字符串2:" + str2);
    }
}
