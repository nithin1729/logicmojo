package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigzagTraversalBT {

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while(!s1.empty() || !s2.empty()) {
            List<Integer> curr = new ArrayList<>();
            if(!s1.empty()) {
                while(!s1.empty()) {
                    TreeNode temp = s1.pop();
                    if(temp.left!=null) s2.add(temp.left);
                    if(temp.right!=null) s2.add(temp.right);
                    curr.add(temp.val);
                }
            }
            else {
                while(!s2.empty()) {
                    TreeNode temp = s2.pop();
                    if(temp.right!=null) s1.add(temp.right);
                    if(temp.left!=null) s1.add(temp.left);
                    curr.add(temp.val);
                }
            }
            ans.add(curr);
        }
        return ans;
    }
}
