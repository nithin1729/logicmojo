package binaryTree;

public class MaximumPathSum {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    int ans;

    private int func(TreeNode root) {
        if(root==null) return 0;
        int left = func(root.left);
        int right = func(root.right);
        // Maximum of root.data + (0,left,right,left+right)
        int currMax = Math.max(Math.max(0,left), Math.max(right,left+right)) + root.val;
        ans = Math.max(ans,currMax);
        return Math.max(0,Math.max(left,right)) + root.val;
    }

    public int maxPathSum(TreeNode root) {
        ans = -1005;
        func(root);
        return ans;
    }
}
