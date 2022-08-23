package dynamicprogramming;

public class EditDistance {

    int[][] dp = new int[101][101];

    private int func(String s, int sIndex, String t, int tIndex) {
        if(dp[sIndex][tIndex] != -1) return dp[sIndex][tIndex];
        if(sIndex == s.length()) return dp[sIndex][tIndex] = t.length() - tIndex;
        if(tIndex == t.length()) return dp[sIndex][tIndex] = s.length() - sIndex;

        if(s.charAt(sIndex) == t.charAt(tIndex)) return dp[sIndex][tIndex] = func(s, sIndex+1, t, tIndex+1);
        return dp[sIndex][tIndex] = 1 + Math.min(Math.min(func(s, sIndex+1, t, tIndex+1), func(s, sIndex+1, t, tIndex)), func(s, sIndex, t, tIndex+1));
    }

    public int editDistance(String s, String t) {
        // Code here
        for(int i=0; i<=s.length(); i++) {
            for(int j=0; j<=t.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return func(s,0,t,0);
    }
}
