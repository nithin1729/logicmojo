package binaryTree;

import java.util.ArrayList;
import java.util.Collections;

public class KDistanceNodesFromAnyNode {

    class Node {
        int data;
        Node left, right;
    }

    static ArrayList<Integer> ans = new ArrayList<>();

    private static void getAll(Node root, int k) {
        if(root==null) return;
        if(k==0) {
            ans.add(root.data);
            return;
        }
        getAll(root.left,k-1);
        getAll(root.right,k-1);
    }

    private static boolean findNode(Node root, int target) {
        if(root==null) return false;
        if(root.data==target) return true;
        return findNode(root.left, target) | findNode(root.right, target);
    }

    private static int getNodeHeight(Node root, int target) {
        if(root==null) return 10005;
        if(root.data==target) return 0;
        return 1 + Math.min(getNodeHeight(root.left,target), getNodeHeight(root.right, target));
    }

    private static void func(Node root, int target, int k) {
        if(root==null) return;
        if(root.data==target) {
            getAll(root,k);
            return;
        }
        boolean leftPresent = findNode(root.left, target);
        if(leftPresent) {
            int height = 1 + getNodeHeight(root.left, target);
            if(k-height-1 >= 0) getAll(root.right, k-height-1);
            if(k==height) ans.add(root.data);

            func(root.left, target, k);
            return;
        }

        boolean rightPresent = findNode(root.right, target);
        if(rightPresent) {
            int height = 1 + getNodeHeight(root.right, target);
            if(k-height-1 >= 0) getAll(root.left, k-height-1);
            if(k==height) ans.add(root.data);

            func(root.right, target, k);
        }
    }

    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        // return the sorted list of all nodes at k dist
        ans.clear();
        func(root,target,k);
        Collections.sort(ans);
        return ans;
    }
}
