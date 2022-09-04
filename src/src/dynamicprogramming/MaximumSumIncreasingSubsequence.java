package dynamicprogramming;

public class MaximumSumIncreasingSubsequence {
    public int maxSumIS(int arr[], int n)
    {
        int[] dp = new int[arr.length];
        for(int i=0; i<arr.length; i++) {
            dp[i] = arr[i];
            for(int j=0; j<i; j++) if(arr[j]<arr[i]) dp[i] = Math.max(dp[i], dp[j]+arr[i]);
        }
        int ans = dp[0];
        for(int i=0; i<dp.length; i++) ans = Math.max(ans, dp[i]);
        return ans;
    }
}
