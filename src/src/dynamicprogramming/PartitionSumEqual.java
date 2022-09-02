package dynamicprogramming;

public class PartitionSumEqual {
    boolean[][] dp = new boolean[201][20001];
    boolean[][] isVisited = new boolean[201][20001];

    private boolean func(int[] nums, int index, int sum) {
        if(isVisited[index][sum] == true) return dp[index][sum];
        isVisited[index][sum] = true;
        if(sum ==0) return dp[index][sum] = true;
        if(index == nums.length) return dp[index][sum] = false;
        if(sum>=nums[index]) if(func(nums,index+1,sum-nums[index])) return dp[index][sum] = true;
        return dp[index][sum] = func(nums,index+1,sum);
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0; i<nums.length; i++) sum += nums[i];
        if(sum%2==1) return false;
        sum = sum/2;
        for(int i=0; i<=nums.length; i++) for(int j=0; j<=sum; j++) isVisited[i][j] = false;
        return func(nums,0,sum);
    }
}
