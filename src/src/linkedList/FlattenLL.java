package linkedList;

public class FlattenLL {

    class Node {
        int val;
        Node prev;
        Node next;
        Node child;

        Node(int val) {
            this.val = val;
            this.prev = null;
            this.next = null;
            this.child = null;
        }

        Node(int val, Node prev, Node next, Node child) {
            this.val = val;
            this.prev = prev;
            this.next = next;
            this.child = child;
        }
    }

    public Node[] func(Node head) {
        Node first = head;
        Node last = head;
        Node temp = head;

        while(temp != null) {
            if(temp.child!= null) {
                Node[] child = func(temp.child);
                Node temp2 = temp.next;
                temp.next = child[0];
                child[0].prev = temp;

                child[1].next = temp2;
                if(temp2!=null)temp2.prev = child[1];
                temp.child = null;
                temp = temp2;
                last = child[1];
            }
            else {
                last = temp;
                temp = temp.next;
            }
        }

        Node[] ans = {first, last};
        return ans;
    }

    public Node flatten(Node head) {
        func(head);
        return head;
    }
}
