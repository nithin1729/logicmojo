package dynamicprogramming;

public class EggDroppingProblem {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[n+1][k+1];
        for(int i=0; i<=k; i++) dp[0][i] = 0;
        int steps = 0;
        while(dp[steps][k] < n) {
            steps++;
            for(int i=1; i<=k; i++) {
                dp[steps][i] = 1 + dp[steps-1][i-1] + dp[steps-1][i];
                /*
                okavela nenu ila annanu anuko.......with 15 tries and 4 eggs, I can search at max 72 floors ani and with 15 tries
                and 5 eggs tho, I can search 94 floors ani

                ippudu adigaru nannu entante 16 tries and 5 eggs ani annaranuko.......nenu em chestanu ante, I will tell that I can calculate
                72 + 1 + 94 endukante, nenu 73rd floor nundi egg drop chestanu and okavela adi pagilthe, I know that now 15 tries are remaining and 4 eggs are left....so,
                icchina information ni batti, I can tell that I can explore below 72 floors.......ala kakunda egg break avvaledanuko then I can tell that I have 15 tries left and 5 eggs are left......so,
                icchina information ni batti, I can explore more 94 floors on top anamata......so, I can explore 71 + 1 + 94 anamata.....
                 */
            }
        }
        return steps;
    }
}
