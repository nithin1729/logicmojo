package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodesAtSameLevel {

    class Node {
        int data;
        Node left;
        Node right;
        Node nextRight;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.nextRight = null;
        }
    }

    public void connect(Node root)
    {
        if(root==null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size()>0) {
            int size = queue.size();
            Node curr = queue.remove();
            if(curr.left!=null) queue.add(curr.left);
            if(curr.right!=null) queue.add(curr.right);
            size--;
            while(size-- > 0) {
                Node temp = queue.remove();
                curr.nextRight = temp;
                curr = temp;
                if(temp.left!=null) queue.add(temp.left);
                if(temp.right!=null) queue.add(temp.right);
            }
            curr.nextRight = null;
        }
    }
}
