package binaryTree;

public class BinaryTreeToSumTree {

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

    private int func(Node root) {
        if(root==null) return 0;
        int val = root.data;

        int left = func(root.left);
        int right = func(root.right);
        root.data = left+right;
        return root.data+val;
    }

    public void toSumTree(Node root){
        //add code here.
        func(root);
    }
}
