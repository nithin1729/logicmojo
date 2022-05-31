package arrays.misc;

public class KthLargestElement {
    private int partition(int[] nums, int left, int right) {
        int curr=left;
        for(int i=left; i<right; i++) {
            if(nums[i]>nums[right]) {
                int temp = nums[curr];
                nums[curr] = nums[i];
                nums[i] = temp;
                curr++;
            }
        }
        int temp = nums[curr];
        nums[curr] = nums[right];
        nums[right] = temp;
        return curr;
    }

    public int findKthLargest(int[] nums, int k) {
        int left=0, right = nums.length-1;
        while(left<=right) {
            int partitionIndex = partition(nums,left,right);
            if(partitionIndex==k-1) {
                return nums[k-1];
            }
            if(partitionIndex>=k) right=partitionIndex-1;
            else left=partitionIndex+1;
        }
        return -1;
    }
}
