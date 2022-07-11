package linkedList;

public class IntersectionOfLL {

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

    private int getLength(ListNode head) {
        int ans = 0;
        while(head!=null) {
            ans++;
            head = head.next;
        }
        return ans;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        if(lenA<lenB) {
            while(lenA<lenB) {
                lenB--;
                headB = headB.next;
            }
        }
        else {
            while(lenB<lenA) {
                lenA--;
                headA = headA.next;
            }
        }

        while(headA!=headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
