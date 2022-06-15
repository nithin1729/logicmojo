package binaryTree;

public class DiameterOfBT {

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

    int ans;

    int func(Node root) {
        if(root==null) return 0;
        int left = func(root.left);
        int right = func(root.right);

        ans = Math.max(ans, left+right+1);
        return Math.max(left,right)+1;
    }

    int diameter(Node root) {
        // Your code here
        ans = 0;
        func(root);
        return ans;
    }
}
