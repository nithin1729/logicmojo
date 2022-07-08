package linkedList;

public class CloneDLLWithRandom {
    class Node {
        int data;
        Node next;
        Node arb;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.arb = null;
        }
    }

    Node copyList(Node head) {
        // your code here
        if(head==null) return null;
        Node temp = head;
        while(temp!=null) {
            Node newNode = new Node(temp.data);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }

        temp = head;
        while(temp!=null) {
            temp.next.arb = temp.arb==null? null: temp.arb.next;
            temp = temp.next.next;
        }

        Node secondHead = head.next;
        Node firstLast = head;
        Node secondLast = secondHead;

        temp = head.next.next;

        while(temp!=null) {
            firstLast.next = temp;
            firstLast = temp;
            temp = temp.next;

            secondLast.next = temp;
            secondLast = temp;
            temp = temp.next;
        }

        firstLast.next = null;
        secondLast.next = null;

        return secondHead;
    }
}
