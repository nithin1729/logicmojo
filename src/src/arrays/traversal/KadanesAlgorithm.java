package arrays.traversal;

public class KadanesAlgorithm {
    private int maxEle(int[] nums) {
        int ans = nums[0];
        for(int i=1; i<nums.length; i++) ans = Math.max(ans,nums[i]);
        return ans;
    }

    public int maxSubArray(int[] nums) {
        int ans = 0;
        int curr=0;
        for(int i=0; i<nums.length; i++) {
            curr+=nums[i];
            if(curr>ans) ans=curr;
            if(curr<0) curr=0;
        }
        if(ans==0)return maxEle(nums);
        return ans;
    }
}
