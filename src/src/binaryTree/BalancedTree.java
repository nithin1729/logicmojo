package binaryTree;

public class BalancedTree {

    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    int findHeight(Node root) {
        if(root==null) return 0;
        return 1 + Math.max(findHeight(root.left), findHeight(root.right));
    }

    //Function to check whether a binary tree is balanced or not.
    boolean isBalanced(Node root)
    {
        if(root==null) return true;
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        if(Math.abs(leftHeight-rightHeight) <= 1) return isBalanced(root.left) & isBalanced(root.right);
        return false;
    }
}
