package backtracking;

import java.util.Arrays;

public class CombinationSumCount {
    int[] dp = new int[1005];
    private int func(int[] arr, int target) {
        if(dp[target]!= -1) return dp[target];
        if(target==0) return dp[target] = 1;
        int ans = 0;
        for(int i=0; i<arr.length && arr[i]<= target; i++) {
            ans += func(arr, target-arr[i]);
            ans %= 1000000007;
        }
        return dp[target] = ans;
    }
    public int countWays(int arr[], int m, int N)
    {
        //code here.
        for(int i=0; i<=N; i++) dp[i] = -1;
        Arrays.sort(arr);
        return func(arr,N);
    }
}
