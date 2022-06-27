package binaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LeftViewOfBT {

    class Node {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    Map<Integer,Integer> map = new HashMap<>();

    void func(Node root, int level) {
        if(root==null) return;
        func(root.left,level+1);
        if(!map.containsKey(level)) map.put(level,root.data);
        func(root.right,level+1);
    }
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
        // Your code here
        map.clear();
        func(root,0);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; map.containsKey(i); i++) {
            ans.add(map.get(i));
        }
        return ans;
    }
}
