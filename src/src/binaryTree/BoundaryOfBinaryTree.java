package binaryTree;

import java.util.ArrayList;

public class BoundaryOfBinaryTree {

    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left=null;
            this.right=null;
        }
    }

    ArrayList<Integer> ans = new ArrayList<>();

    private void leftBoundary(Node root) {
        if(root==null || (root.left==null && root.right==null)) return;

        ans.add(root.data);
        if(root.left!=null) leftBoundary(root.left);
        else leftBoundary(root.right);
    }

    private void rightBoundary(Node root) {
        if(root==null || (root.left==null && root.right==null)) return;

        if(root.right!=null) rightBoundary(root.right);
        else rightBoundary(root.left);
        ans.add(root.data);
    }

    private void leafNodes(Node root) {
        if(root==null) return;
        if(root.left==null && root.right==null) {
            ans.add(root.data);
            return;
        }
        leafNodes(root.left);
        leafNodes(root.right);
    }

    ArrayList <Integer> boundary(Node node)
    {
        ans.clear();
        if(node==null) return ans;
        ans.add(node.data);

        leftBoundary(node.left);
        leafNodes(node.left);
        leafNodes(node.right);
        rightBoundary(node.right);

        return ans;
    }
}
