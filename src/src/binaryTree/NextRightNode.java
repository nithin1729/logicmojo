package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class NextRightNode {

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

    Node nextRight(Node root, int key)
    {
        //Write your code here
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size()>0) {
            int size = queue.size();
            while(size-- > 0) {
                Node temp = queue.remove();
                if(temp.data==key) {
                    if(size==0) return new Node(-1);
                    return queue.remove();
                }
                if(temp.left!=null) queue.add(temp.left);
                if(temp.right!=null) queue.add(temp.right);
            }
        }
        return new Node(-1);
    }
}
