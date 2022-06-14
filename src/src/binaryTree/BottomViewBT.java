package binaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BottomViewBT {
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
    class Pair {
        int key;
        int value;

        Pair(int key, int value) {
            this.key=key;
            this.value=value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }
    }

    Map<Integer, Pair > map = new HashMap<>(); // y -> (height, value)
    int minY, maxY;

    private void func(Node root, int y, int height) {
        if(root==null) return;
        minY = Math.min(minY,y);
        maxY = Math.max(maxY,y);
        if(!map.containsKey(y) || map.get(y).getKey()<=height) {
            map.put(y, new Pair(height, root.data));
        }
        func(root.left,y-1,height+1);
        func(root.right,y+1,height+1);
    }
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList<Integer> bottomView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        map.clear();
        minY=0;
        maxY=0;
        func(root,0,0);
        for(int i=minY; i<=maxY; i++) ans.add(map.get(i).getValue());
        return ans;
    }
}
