package binaryTree;

import java.util.ArrayList;

public class SerializeDeserializeArray {

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

    int index;
    //Function to serialize a tree and return a list containing nodes of tree.
    public void serialize(Node root, ArrayList<Integer> A)
    {
        //code here
        if(root==null) {
            A.add(-1);
            return;
        }
        A.add(root.data);
        serialize(root.left,A);
        serialize(root.right,A);
    }

    private Node func(ArrayList<Integer> A) {
        if(index==A.size()) return null;
        if(A.get(index)==-1) {
            index++;
            return null;
        }
        Node ans = new Node(A.get(index));
        index++;
        ans.left = func(A);
        ans.right = func(A);
        return ans;
    }

    //Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> A)
    {
        //code here
        index = 0;
        return func(A);
    }
}
