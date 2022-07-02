package binaryTree;

public class NextRightNode2 {

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

    boolean isFound;
    int foundLevel;
    Node ans;

    void func(Node root, int key, int currLevel) {
        if(isFound || root==null) return;
        func(root.left,key,currLevel+1);
        if(root.data==key) {
            foundLevel = currLevel;
        }
        else if(foundLevel>=0 && currLevel==foundLevel) {
            isFound=true;
            ans=root;
        }
        func(root.right,key,currLevel+1);
    }

    Node nextRight(Node root, int key)
    {
        isFound=false;
        foundLevel=-1;
        ans=new Node(-1);
        func(root,key,0);
        return ans;
    }
}
