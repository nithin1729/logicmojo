package dynamicprogramming;

public class RodCuttingForMaximumProfit {
    int[][] dp = new int[1001][1001];

    private int func(int[] price, int currIndex, int len) {
        if(dp[currIndex][len] != -1) return dp[currIndex][len];
        if(len == 0) return dp[currIndex][len] = 0;
        if(currIndex == price.length || len <= currIndex) return dp[currIndex][len] = Integer.MIN_VALUE;

        int ans = Integer.MIN_VALUE;

        for(int pieces = 0; pieces*(currIndex+1) <= len; pieces++) {
            ans = Math.max(ans, pieces*price[currIndex] + func(price,currIndex+1,len-pieces*(currIndex+1)));
        }
        return dp[currIndex][len] = ans;
    }

    public int cutRod(int price[], int n) {
        //code here
        for(int i=0; i<=price.length; i++) {
            for(int j=0; j<=n; j++) {
                dp[i][j] = -1;
            }
        }
        return func(price,0,n);
    }
}
