package arrays.misc;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 0;
        int num=0;
        for(int i=0; i<nums.length; i++) {
            if(count==0) {
                count++;
                num = nums[i];
            }
            else if(nums[i]==num) count++;
            else count--;
        }

        count = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]==num) count++;
        }
        if(count>nums.length/2) return num;
        return -1;
    }
}
