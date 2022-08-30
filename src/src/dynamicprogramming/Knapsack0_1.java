package dynamicprogramming;

public class Knapsack0_1 {
    static int[][] dp = new int[1001][1001];
    private static int func(int W, int[] wt, int[] val, int index) {
        if(dp[W][index] != -1) return dp[W][index];
        if(W==0 || index >= wt.length) return dp[W][index] = 0;
        int ans = 0;
        if(W>=wt[index]) {
            ans = val[index] + func(W-wt[index],wt,val,index+1);
        }
        ans = Math.max(ans, func(W,wt,val,index+1));
        return dp[W][index] = ans;
    }
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n)
    {
        // your code here
        for(int i=0; i<=W; i++) for(int j=0; j<=n; j++) dp[i][j] = -1;
        return func(W,wt,val,0);
    }
}
