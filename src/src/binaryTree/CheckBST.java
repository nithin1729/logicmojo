package binaryTree;

public class CheckBST {

    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private boolean check(Node root, long minValue, long maxValue) {
        if(root==null) return true;
        if(root.data<minValue || root.data>maxValue) return false;
        long rootData = root.data;
        return check(root.left, minValue, rootData-1) & check(root.right, rootData+1, maxValue);
    }

    //Function to check whether a Binary Tree is BST or not.
    boolean isBST(Node root)
    {
        return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
