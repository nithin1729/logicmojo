package binaryTree;

public class ConstructBTFromInPostOrder {

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

    Node constructTree(int[] in, int inStart, int inEnd, int[] post, int postStart, int postEnd) {
        if(inStart > inEnd) return null;
        if(inStart==inEnd) return new Node(in[inStart]);

        Node root = new Node(post[postEnd]);
        int index = inStart;
        while(in[index] != post[postEnd]) index++;
        root.left = constructTree(in, inStart,index-1, post, postStart, postStart+index-1-inStart);
        root.right = constructTree(in, index+1, inEnd, post, postStart+index-inStart , postEnd-1);
        return root;
    }

    //Function to return a tree created from postorder and inoreder traversals.
    Node buildTree(int in[], int post[], int n) {
        // Your code here
        return constructTree(in, 0, n-1, post, 0, n-1);
    }
}
