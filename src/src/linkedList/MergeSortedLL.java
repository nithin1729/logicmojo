package linkedList;

public class MergeSortedLL {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;

        ListNode ans;
        if(list1.val<list2.val) {
            ans=list1;
            list1 = list1.next;
        }
        else {
            ans=list2;
            list2 = list2.next;
        }
        ListNode last = ans;

        while(list1!=null&&list2!=null) {
            if(list1.val<list2.val) {
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
}
