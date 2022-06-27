package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TraversalReverseLevel {
    class Node {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
    public ArrayList<Integer> reverseLevelOrder(Node node)
    {
        // code here
        Queue<Node> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        queue.add(node);
        while(queue.size()>0) {
            Node curr = queue.poll();
            stack.push(curr.data);
            if(curr.right!=null) queue.add(curr.right);
            if(curr.left!=null) queue.add(curr.left);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!stack.isEmpty()) {
            ans.add(stack.pop());
        }
        return ans;
    }
}
