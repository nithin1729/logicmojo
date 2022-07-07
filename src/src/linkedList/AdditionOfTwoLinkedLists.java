package linkedList;

public class AdditionOfTwoLinkedLists {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;

        int carry = 0;
        ListNode ansHead = new ListNode((carry+l1.val+l2.val));
        ListNode last = ansHead;
        l1 = l1.next;
        l2 = l2.next;
        carry = ansHead.val/10;
        ansHead.val = (ansHead.val)%10;
        while(l1!= null && l2!=null) {
            last.next = new ListNode((carry+l1.val+l2.val));
            last = last.next;

            carry = last.val / 10;
            last.val %= 10;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1!=null) {
            last.next = new ListNode((carry+l1.val));
            last = last.next;

            carry = last.val / 10;
            last.val %= 10;
            l1 = l1.next;
        }

        while(l2!=null) {
            last.next = new ListNode((carry+l2.val));
            last = last.next;

            carry = last.val / 10;
            last.val %= 10;
            l2 = l2.next;
        }

        if(carry>0) last.next = new ListNode(carry);
        return ansHead;
    }
}
