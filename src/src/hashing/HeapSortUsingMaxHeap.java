package hashing;

public class HeapSortUsingMaxHeap {
    void maxHeapify(int[] nums, int numsLength, int index) {
        int maxIndex = index;
        int left = 2*index + 1;
        int right = 2*index + 2;

        if(left<numsLength && nums[left]>nums[maxIndex]) maxIndex = left;
        if(right<numsLength && nums[right]>nums[maxIndex]) maxIndex = right;

        if(maxIndex != index) {
            nums[maxIndex] = nums[maxIndex] ^ nums[index];
            nums[index] = nums[maxIndex] ^ nums[index];
            nums[maxIndex] = nums[maxIndex] ^ nums[index];

            maxHeapify(nums, numsLength, maxIndex);
        }
    }

    public int[] sortArray(int[] nums) {
        for(int i=nums.length/2-1; i>=0; i--) maxHeapify(nums,nums.length,i);

        for(int i=nums.length-1; i>0; i--) {
            nums[i] = nums[i] ^ nums[0];
            nums[0] = nums[i] ^ nums[0];
            nums[i] = nums[i] ^ nums[0];

            maxHeapify(nums, i, 0);
        }
        return nums;
    }
}
