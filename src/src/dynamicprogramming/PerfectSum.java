package dynamicprogramming;

public class PerfectSum {
    public int perfectSum(int arr[],int n, int sum)
    {
        // Your code goes here
        int[][] dp = new int[n+1][sum+1];
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=sum; j++) {
                if(i==0) {
                    dp[i][j] = (j==0)? 1: 0;
                    continue;
                }
                dp[i][j] = dp[i-1][j];
                if(arr[i-1] <= j) {
                    dp[i][j] +=  dp[i-1][j-arr[i-1]];
                    dp[i][j] %= 1000000007;
                }
            }
        }
        return dp[n][sum];
    }
}
