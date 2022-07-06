package linkedList;

public class PalindromeLL {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private ListNode findMiddle(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;

        while(fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverseLL(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head;

        while(curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        ListNode middleNode = findMiddle(head);
        ListNode secondLL = middleNode.next;
        middleNode.next = null;

        secondLL = reverseLL(secondLL);
        while(head!=null && secondLL!=null) {
            if(head.val != secondLL.val) return false;
            head = head.next;
            secondLL = secondLL.next;
        }
        return true;
    }
}
