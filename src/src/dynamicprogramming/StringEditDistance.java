package dynamicprogramming;

public class StringEditDistance {
    int[][] dp = new int[501][501];

    private int func(String word1, int word1Index, String word2, int word2Index) {
        if(dp[word1Index][word2Index] != -1) return dp[word1Index][word2Index];
        if(word1Index == word1.length() || word2Index == word2.length()) return dp[word1Index][word2Index] = word1.length()+word2.length()-word1Index-word2Index;

        if(word1.charAt(word1Index) == word2.charAt(word2Index)) return dp[word1Index][word2Index] = func(word1, word1Index+1, word2, word2Index+1);
        return dp[word1Index][word2Index] = 1 + Math.min(func(word1,word1Index+1,word2,word2Index+1), Math.min(func(word1,word1Index+1,word2,word2Index), func(word1,word1Index,word2,word2Index+1)));
    }

    public int minDistance(String word1, String word2) {
        for(int i=0; i<=word1.length(); i++) {
            for(int j=0; j<=word2.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return func(word1, 0, word2, 0);
    }
}
