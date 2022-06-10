package binaryTree;

public class BinaryTreeToDLL {
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

    Node ans;
    Node prev;

    private void inOrder(Node root) {
        if(root==null) return;
        inOrder(root.left);
        if(prev==null) {
            ans = root;
            prev=root;
        }
        else {
            prev.right = root;
            root.left = prev;
            prev = root;
        }
        inOrder(root.right);
    }

    Node bToDLL(Node root)
    {
        //  Your code here
        ans = null;
        prev = null;
        inOrder(root);
        return ans;
    }
}
