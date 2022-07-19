package hashing;

import java.util.ArrayList;

public class MergeKSortedLists {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        ListNode() {

        }
    }

    private void minHeapifyUp(ArrayList<ListNode> arr, int index) {
        if(index == 0) return;
        int parent = (index-1)/2;
        if(arr.get(index).val < arr.get(parent).val) {
            //swap index, parent
            ListNode temp = arr.get(parent);
            arr.set(parent, arr.get(index));
            arr.set(index, temp);
            minHeapifyUp(arr,parent);
        }
    }

    private void minHeapifyDown(ArrayList<ListNode> arr, int index) {
        int minIndex = index;
        int left = 2*index + 1;
        int right = 2*index + 2;

        if(left<arr.size() && arr.get(minIndex).val > arr.get(left).val) minIndex = left;
        if(right<arr.size() && arr.get(minIndex).val > arr.get(right).val) minIndex = right;

        if(minIndex != index) {
            ListNode temp = arr.get(minIndex);
            arr.set(minIndex, arr.get(index));
            arr.set(index, temp);
            minHeapifyDown(arr,minIndex);
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<ListNode> arr = new ArrayList<>();
        for(int i=0; i<lists.length; i++) {
            if(lists[i]!=null) {
                arr.add(lists[i]);
                minHeapifyUp(arr,arr.size()-1);
            }
        }
        ListNode ans = null;
        ListNode last = null;

        while(arr.size()!=0) {
            ListNode curr = arr.get(0);
            if(curr.next==null) {
                arr.set(0, arr.get(arr.size()-1));
                arr.remove(arr.size()-1);
            }
            else {
                arr.set(0, curr.next);
            }
            minHeapifyDown(arr,0);

            if(last==null) {
                ans = last = curr;
            }
            else {
                last.next = curr;
                last = curr;
            }
        }
        return ans;
    }
}
