package binaryTree;

public class RootToLeafMaxSum {
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

    public static int maxPathSum(Node root)
    {
        if(root==null) return 0;
        return root.data + Math.max(maxPathSum(root.left), maxPathSum(root.right));
    }
}
