package arrays.misc;

import java.util.Stack;

public class StackCustomImplementation {
    class DoublyLL {
        int data;
        DoublyLL prev;
        DoublyLL next;

        DoublyLL(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    DoublyLL head;
    DoublyLL middle;
    int size;

    StackCustomImplementation() {
        head = null;
        middle = null;
        size = 0;
    }

    public void push(int data) {
        size++;
        DoublyLL newNode = new DoublyLL(data);
        if(head==null) {
            head=newNode;
            middle=newNode;
            return;
        }
        newNode.next=head;
        head.prev=newNode;
        if(size%2==1) {
            middle=middle.next;
        }
    }

    public int pop() throws Exception {
        if(head==null) throw new Exception("Stack is empty");
        size--;
        if(size==0) {
            int ans = head.data;
            head=null;
            middle=null;
            return ans;
        }
        if(size%2==1) {
            middle=middle.next;
        }
        int ans = head.data;
        head = head.next;
        head.prev=null;
        return ans;
    }

    public int getMiddle() throws Exception {
        if(middle==null) throw new Exception("Stack is empty");
        return middle.data;
    }
    public int deleteMiddle() throws Exception {
        if(middle==null) throw new Exception("Stack is empty");
        int ans = middle.data;
        size--;
        if(size==0) {
            head=null;
            middle=null;
            return ans;
        }
        if(size==1) {
            middle = middle.next;
            head = head.next;
            head.prev=null;
            return ans;
        }
        if(size%2==1) {
            DoublyLL temp = middle.prev;
            temp.next = middle.next;
            middle=middle.next;
            middle.prev=temp;
            return ans;
        }
        middle=middle.prev;
        middle.next=middle.next.next;
        middle.next.next.prev = middle;
        return ans;
    }
}
