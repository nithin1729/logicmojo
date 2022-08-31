package dynamicprogramming;

public class SpecialKeyboard {
    static int[] dp = new int[77];
    static int func(int N) {
        if(dp[N] != -1) return dp[N];
        if(N<=6) return dp[N] = N;
        int ans = 0;
        for(int i=1; i<=N-3; i++) ans = Math.max(i*func(N-1-i), ans);
        return dp[N] = ans;
    }

    static int optimalKeys(int N){
        // code here
        for(int i=0; i<=N; i++) dp[i] = -1;
        return func(N);
    }
}
