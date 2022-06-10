package binaryTree;

public class KthSmallestBST2 {
    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public int KthSmallestElement(Node root, int K) {
        // Write your code here
        int currCount=0;
        Node curr = root;
        int ans = -1;
        while(curr != null) {
            if(curr.left == null) {
                currCount++;
                if(currCount==K) ans = curr.data;
                curr = curr.right;
            }
            else {
                Node temp = curr.left;
                while(temp.right!=null && temp.right!=curr) {
                    temp = temp.right;
                }
                if(temp.right==null) {
                    temp.right=curr;
                    curr = curr.left;
                }
                else {
                    temp.right = null;
                    currCount++;
                    if(currCount==K) ans = curr.data;
                    curr = curr.right;
                }
            }
        }
        return ans;
    }
}
