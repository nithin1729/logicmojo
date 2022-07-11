package linkedList;

public class ReverseLLInSizeK {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private ListNode reverseLL(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while(curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null) return head;
        int currCount = 1;
        ListNode temp = head;
        while(temp!=null && currCount<k) {
            currCount++;
            temp = temp.next;
        }
        if(temp==null) return head;
        ListNode head2 = temp.next;
        temp.next = null;
        ListNode ans = reverseLL(head);
        head.next = reverseKGroup(head2,k);
        return ans;
    }
}
