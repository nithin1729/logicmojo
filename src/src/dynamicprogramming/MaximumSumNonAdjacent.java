package dynamicprogramming;

public class MaximumSumNonAdjacent {
    public int calculateSum(int[] nums) {
        int ans = Math.max(nums[0],0);
        int withPrev = nums[0];
        int withoutPrev = 0;

        for(int i=1; i<nums.length; i++) {
            int withPrevTemp = withoutPrev + nums[i];
            int withoutPrevTemp = Math.max(withPrev, withoutPrev);

            withPrev = withPrevTemp;
            withoutPrev = withoutPrevTemp;

            ans = Math.max(ans, Math.max(withPrev, withoutPrev));
        }
        return ans;
    }
}
