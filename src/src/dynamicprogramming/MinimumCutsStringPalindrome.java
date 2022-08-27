package dynamicprogramming;

public class MinimumCutsStringPalindrome {
    int[] dp = new int[2001];

    private int func(boolean[][] isPalindrome, int currIndex) {
        if(dp[currIndex] != -1) return dp[currIndex];
        if(currIndex == isPalindrome.length) return dp[currIndex] = 0;

        int ans = 2005;
        for(int i=currIndex; i<isPalindrome.length; i++) {
            if(isPalindrome[currIndex][i] == true) {
                ans = Math.min(ans, 1 + func(isPalindrome, i+1));
            }
        }
        return dp[currIndex] = ans;
    }

    public int minCut(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];

        for(int len = 1; len <= s.length(); len++) {
            for(int i=0; i+len<=s.length(); i++) {
                char left = s.charAt(i);
                char right = s.charAt(i+len-1);

                if(len == 1 || (left==right && (len == 2 || isPalindrome[i+1][i+len-2] == true))) isPalindrome[i][i+len-1] = true;
                else isPalindrome[i][i+len-1] = false;
            }
        }

        for(int i=0; i<=s.length(); i++) dp[i] = -1;
        return func(isPalindrome,0) - 1;
    }
}
