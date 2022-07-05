package binaryTree;

import javax.print.attribute.standard.MediaSize;

public class MirrorTrees {
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

    class NAryNode {
        private static final int size = 10;
        int data;
        NAryNode[] child;

        NAryNode(int data) {
            this.data = data;
            child = new NAryNode[size];
            for(int i=0; i<size; i++) child[i] = null;
        }
    }

    boolean areMirror(Node root1, Node root2) {
        if(root1==null && root2==null) return true;
        if(root1==null || root2==null || root1.data!=root2.data) return false;
        return areMirror(root1.left,root2.right) & areMirror(root1.right,root2.left);
    }

    boolean areMirror(NAryNode root1, NAryNode root2) {
        if(root1==null && root2==null) return true;
        if(root1==null || root2==null || root1.data!=root2.data) return false;

        for(int i=0; i<root1.child.length; i++) {
            if(!areMirror(root1.child[i], root2.child[root2.child.length-1-i])) {
                return false;
            }
        }
        return true;
    }

}
