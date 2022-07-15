package hashing;

public class HeapSortUsingMinHeap {
    void minHeapify(int[] nums, int numsLength, int index) {
        int minIndex = index;
        int left = 2*index + 1;
        int right = 2*index + 2;

        if(left<numsLength && nums[left]<nums[minIndex]) minIndex = left;
        if(right<numsLength && nums[right]<nums[minIndex]) minIndex = right;

        if(minIndex != index) {
            nums[minIndex] = nums[minIndex] ^ nums[index];
            nums[index] = nums[minIndex] ^ nums[index];
            nums[minIndex] = nums[minIndex] ^ nums[index];

            minHeapify(nums, numsLength, minIndex);
        }
    }

    public int[] sortArray(int[] nums) {
        for(int i=nums.length/2-1; i>=0; i--) minHeapify(nums,nums.length,i);

        for(int i=nums.length-1; i>0; i--) {
            nums[i] = nums[i] ^ nums[0];
            nums[0] = nums[i] ^ nums[0];
            nums[i] = nums[i] ^ nums[0];

            minHeapify(nums, i, 0);
        }
        int left = 0, right = nums.length-1;
        while(left < right) {
            nums[left] = nums[left] ^ nums[right];
            nums[right] = nums[left] ^ nums[right];
            nums[left] = nums[left] ^ nums[right];
            left++;
            right--;
        }
        return nums;
    }
}
