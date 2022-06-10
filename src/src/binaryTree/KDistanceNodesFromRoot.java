package binaryTree;

import java.util.ArrayList;

public class KDistanceNodesFromRoot {

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

    ArrayList<Integer> ans = new ArrayList<>();

    void getAll(Node root, int k) {
        if(root==null) return;
        if(k==0) {
            ans.add(root.data);
            return;
        }
        getAll(root.left,k-1);
        getAll(root.right,k-1);
    }

    ArrayList<Integer> Kdistance(Node root, int k)
    {
        // Your code here
        ans.clear();
        getAll(root,k);
        return ans;
    }
}
