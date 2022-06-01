package arrays.searchingAlgo;

public class SingleElementTwoNumbers {
    public int[] singleNumber(int[] nums) {
        int xorAns = 0;
        for(int i=0; i<nums.length; i++) {
            xorAns = xorAns ^ nums[i];
        }
        int rightMostBit = xorAns & (~(xorAns-1));
        int a = 0;
        int b = 0;
        for(int i=0; i<nums.length; i++) {
            int temp = nums[i] & rightMostBit;
            if(temp != 0) {
                a = a ^ nums[i];
            }
            else {
                b = b ^ nums[i];
            }
        }
        int[] ans = {a,b};
        return ans;
    }
}
