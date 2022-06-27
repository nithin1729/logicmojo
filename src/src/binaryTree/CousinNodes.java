package binaryTree;

import java.util.ArrayList;

public class CousinNodes {
    class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }
    ArrayList<Integer> first = new ArrayList<>();
    ArrayList<Integer> second = new ArrayList<>();

    void func(Node root, int a, int b, ArrayList<Integer> path) {
        if(root==null) return;
        path.add(root.data);
        if(root.data==a) {
            for(int i=0; i<path.size(); i++) first.add(path.get(i));
        }
        else if(root.data==b) {
            for(int i=0; i<path.size(); i++) second.add(path.get(i));
        }
        func(root.left,a,b,path);
        func(root.right,a,b,path);
        path.remove(path.size()-1);
    }

    // Returns true if the nodes with values 'a' and 'b' are cousins. Else returns false
    public boolean isCousins(Node root, int a, int b) {
        // your code here
        // This function should return true if x and y are cousins, else return false
        first.clear();
        second.clear();
        ArrayList<Integer> path = new ArrayList<>();
        func(root,a,b,path);
        if(first.size()==0) return false;
        if(first.size()!=second.size()) return false;
        return !(first.get(first.size()-2)==second.get(second.size()-2));
    }
}
