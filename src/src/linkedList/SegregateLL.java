package linkedList;

public class SegregateLL {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    Node divide(int N, Node head){
        // code here
        Node even = null;
        Node evenLast = null;

        Node odd = null;
        Node oddLast = null;

        while(head != null) {
            if(head.data % 2 == 0) {
                if(evenLast == null) {
                    even = head;
                    evenLast = head;
                    head = head.next;
                }
                else {
                    evenLast.next = head;
                    evenLast = evenLast.next;
                    head = head.next;
                }
                evenLast.next = null;
            }
            else {
                if(oddLast == null) {
                    odd = head;
                    oddLast = head;
                    head = head.next;
                }
                else {
                    oddLast.next = head;
                    oddLast = oddLast.next;
                    head = head.next;
                }
                oddLast.next = null;
            }
        }
        if(even==null) return odd;
        evenLast.next = odd;
        return even;
    }
}
