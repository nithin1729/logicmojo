package dynamicprogramming;

public class CoinChange {
    int[][] dp = new int[15][10005];

    private int func(int[] coins, int currIndex, int amount) {
        if(dp[currIndex][amount] != -2) return dp[currIndex][amount];
        if(amount == 0) return dp[currIndex][amount] = 0;
        if(currIndex == coins.length || coins[currIndex] > amount) return dp[currIndex][amount] = -1;
        int ans = -1;
        boolean found = false;
        for(int i=0; i*coins[currIndex] <= amount; i++) {
            int temp = func(coins, currIndex+1, amount - i*coins[currIndex]);
            if(temp != -1) {
                if(found == false) {
                    found = true;
                    ans = i + temp;
                }
                else {
                    ans = Math.min(ans, i+temp);
                }
            }
        }
        return dp[currIndex][amount] = ans;
    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        for(int i=0; i<=coins.length; i++) {
            for(int j=0; j<=amount; j++) {
                dp[i][j] = -2;
            }
        }
        return func(coins, 0, amount);
    }
}
