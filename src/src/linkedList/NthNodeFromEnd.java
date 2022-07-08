package linkedList;

public class NthNodeFromEnd {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public int getNthFromLast(Node head, int n) {
        int count = 0;
        Node temp = head;
        while(count < n && temp != null) {
            count++;
            temp = temp.next;
        }
        if(count != n) return -1;
        Node temp2 = head;
        while(temp!=null) {
            temp = temp.next;
            temp2 = temp2.next;
        }
        return temp2.data;
    }
}
