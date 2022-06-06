package binaryTree;

public class KthSmallestBST {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }

    int currCount;
    int ans;

    private void inOrder(TreeNode root, int k) {
        if(root==null) return;
        if(currCount<k) inOrder(root.left,k);
        currCount++;
        if(currCount==k) {
            ans = root.val;
            return;
        }
        if(currCount<k)inOrder(root.right,k);
    }

    public int kthSmallest(TreeNode root, int k) {
        currCount=0;
        ans=-1;
        inOrder(root,k);
        return ans;
    }
}
