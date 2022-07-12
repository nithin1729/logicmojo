package linkedList;

public class ReOrderLL {

    class ListNode {
        int val;
        ListNode next;

        ListNode() {

        }

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
        ListNode prev = null, curr = head, next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public void reorderList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null) return;
        ListNode fast = head.next;
        ListNode slow = head;

        while(fast!= null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode head2 = reverseLL(temp);
        ListNode ans = head;
        ListNode last = head;
        head = head.next;
        while(head != null && head2!= null) {
            last.next = head2;
            head2 = head2.next;
            last = last.next;

            last.next = head;
            head = head.next;
            last = last.next;
        }
        if(head!=null) {
            last.next = head;
        }
        if(head2!=null) {
            last.next = head2;
        }
    }
}
