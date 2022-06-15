package binaryTree;

public class LargestBSTinBT {
    static int ans;

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

    static class NodeInfo {
        int minimum;
        int maximum;
        int size;
        boolean isBST;

        NodeInfo(int minimum, int maximum, int size, boolean isBST) {
            this.minimum = minimum;
            this.maximum = maximum;
            this.size = size;
            this.isBST = isBST;
        }
    }

    static NodeInfo func(Node root) {
        if(root==null) return new NodeInfo(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, true);
        if(root.left==null && root.right==null) {
            ans = Math.max(ans,1);
            return new NodeInfo(root.data, root.data, 1, true);
        }
        NodeInfo left;
        NodeInfo right;

        if(root.left==null) left = new NodeInfo(root.data, Integer.MIN_VALUE,0,true);
        else left = func(root.left);

        if(root.right==null) right = new NodeInfo(Integer.MAX_VALUE, root.data,0,true);
        else right = func(root.right);

        if(left.isBST && right.isBST) {
            if(left.maximum < root.data && root.data < right.minimum) {
                ans = Math.max(ans,left.size+right.size+1);
                return new NodeInfo(left.minimum, right.maximum,left.size+right.size+1,true);
            }
        }
        return new NodeInfo(-1,-1,-1,false);
    }


    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        // Write your code here
        ans = 0;
        if(root==null) return 0;
        func(root);
        return ans;
    }
}
