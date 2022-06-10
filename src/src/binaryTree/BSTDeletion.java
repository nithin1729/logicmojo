package binaryTree;

public class BSTDeletion {

    class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }

    private int getMinimum(TreeNode root) {
        while(root.left!=null) root=root.left;
        return root.val;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return root;
        if(root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        if(root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        if(root.left==null && root.right==null) return null;
        if(root.left==null) return root.right;
        if(root.right==null) return root.left;

        int minValue = getMinimum(root.right);
        root.val=minValue;
        root.right = deleteNode(root.right,minValue);
        return root;
    }
}
