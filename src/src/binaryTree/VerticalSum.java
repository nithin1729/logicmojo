package binaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VerticalSum {

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

    int minVertex, maxVertex;
    Map<Integer, Integer> map = new HashMap<>();

    void func(Node root, int vertex) {
        if(root==null) return;
        minVertex = Math.min(minVertex, vertex);
        maxVertex = Math.max(maxVertex, vertex);

        if(!map.containsKey(vertex)) map.put(vertex,0);
        map.put(vertex, map.get(vertex)+root.data);
        func(root.left,vertex-1);
        func(root.right,vertex+1);
    }

    public ArrayList<Integer> verticalSum(Node root) {
        // add your code here
        ArrayList<Integer> arr = new ArrayList<>();
        if(root==null) {
            return arr;
        }
        map.clear();
        minVertex = 0;
        maxVertex = 0;
        func(root,0);
        for(int i=minVertex; i<=maxVertex; i++) arr.add(map.get(i));
        return arr;
    }
}
