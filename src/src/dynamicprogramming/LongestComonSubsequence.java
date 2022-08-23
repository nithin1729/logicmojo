package dynamicprogramming;

public class LongestComonSubsequence {
    int[][] dp = new int[1001][1001];

    private int func(String text1, int text1Index, String text2, int text2Index) {
        if(dp[text1Index][text2Index] != -1) return dp[text1Index][text2Index];
        if(text1Index == text1.length() || text2Index == text2.length()) return dp[text1Index][text2Index] = 0;
        if(text1.charAt(text1Index) == text2.charAt(text2Index)) {
            return dp[text1Index][text2Index] = 1 + func(text1, text1Index+1, text2, text2Index+1);
        }
        return dp[text1Index][text2Index] = Math.max(func(text1, text1Index+1, text2, text2Index), func(text1, text1Index, text2, text2Index+1));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        for(int i=0; i<=text1.length(); i++) {
            for(int j=0; j<=text2.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return func(text1, 0, text2, 0);
    }
}
