package dynamicprogramming;

public class LongestPalindromeSubsequence {
    int[][] dp = new int[1001][1001];

    private int func(String str, int start, int end) {
        if(dp[start][end] != -1) return dp[start][end];
        if(start==end) return dp[start][end] = 1;
        if(start>end) return dp[start][end] = 0;

        if(str.charAt(start) == str.charAt(end)) return dp[start][end] = 2 + func(str, start+1, end-1);
        return dp[start][end] = Math.max(func(str,start+1,end), func(str,start,end-1));
    }

    public int longestPalindromeSubseq(String s) {
        for(int i=0; i<=s.length(); i++) {
            for(int j=0; j<=s.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return func(s,0,s.length()-1);
    }
}
