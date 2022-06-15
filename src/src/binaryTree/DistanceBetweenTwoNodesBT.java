package binaryTree;

public class DistanceBetweenTwoNodesBT {

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

    Node findLCA(Node root, int val1, int val2) {
        if(root==null) return null;
        if(root.data==val1 || root.data==val2) return root;

        Node leftSide = findLCA(root.left, val1, val2);
        Node rightSide = findLCA(root.right, val1, val2);



        if(leftSide!=null && rightSide!=null) return root;
        if(leftSide==null && rightSide==null) return null;
        if(leftSide==null) return findLCA(root.right, val1, val2);
        return findLCA(root.left, val1, val2);
    }

    int findDistance(Node root, int data) {
        if(root==null) return 10004;
        if(root.data==data) return 0;
        return 1 + Math.min(findDistance(root.left,data),findDistance(root.right,data));
    }

    int findDist(Node root, int a, int b) {
        // Your code here
        Node lca = findLCA(root, a, b);
        //System.out.println(lca.data);
        return findDistance(lca,a) + findDistance(lca,b);
    }
}
