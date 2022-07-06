package linkedList;

public class MergeSortOnLL {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private static Node mergeTwoLists(Node list1, Node list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;

        Node ans;
        if(list1.data<list2.data) {
            ans=list1;
            list1 = list1.next;
        }
        else {
            ans=list2;
            list2 = list2.next;
        }
        Node last = ans;

        while(list1!=null&&list2!=null) {
            if(list1.data<list2.data) {
                last.next = list1;
                list1 = list1.next;
            }
            else {
                last.next = list2;
                list2 = list2.next;
            }
            last = last.next;
        }
        if(list1!=null) last.next = list1;
        if(list2!=null) last.next = list2;
        return ans;
    }

    private static Node findMiddle(Node head) {
        Node fast = head.next;
        Node slow = head;

        while(fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head)
    {
        // add your code here
        if(head==null || head.next==null) return head;
        Node middle = findMiddle(head);
        Node secondHead = middle.next;
        middle.next = null;
        head = mergeSort(head);
        secondHead = mergeSort(secondHead);
        return mergeTwoLists(head,secondHead);
    }
}
