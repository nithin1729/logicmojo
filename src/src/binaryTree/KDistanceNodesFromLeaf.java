package binaryTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KDistanceNodesFromLeaf {

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

    Set<Node> nodes = new HashSet<>();
    List<Node> list = new ArrayList<>();

    private void func(Node root, int k) {
        if(root==null) return;
        list.add(root);
        if(root.left==null && root.right==null) {
            if(list.size()-k-1>=0) nodes.add(list.get(list.size()-k-1));
            list.remove(list.size()-1);
            return;
        }
        func(root.left,k);
        func(root.right,k);
        list.remove(list.size()-1);
    }

    int printKDistantfromLeaf(Node root, int k)
    {
        // Write your code here
        nodes.clear();
        list.clear();

        func(root,k);

        return nodes.size();
    }
}
