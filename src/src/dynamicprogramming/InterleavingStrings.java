package dynamicprogramming;

public class InterleavingStrings {
    boolean[][] dp = new boolean[101][101];
    boolean[][] isVisited = new boolean[101][101];
    private boolean func(String s1, int s1Index, String s2, int s2Index, String s3) {
        System.out.println("LOG");
        if(isVisited[s1Index][s2Index] == true) return dp[s1Index][s2Index];
        System.out.println("LOG");
        isVisited[s1Index][s2Index] = true;
        System.out.println("LOG");
        if(s1Index == s1.length() && s2Index == s2.length()) return dp[s1Index][s2Index] = true;
        if(s1Index == s1.length()) {
            while(s2Index != s2.length() && s2.charAt(s2Index) == s3.charAt(s1Index + s2Index)) s2Index++;
            return dp[s1Index][s2Index] = (s2Index == s2.length() ? true : false);
        }
        if(s2Index == s2.length()) {

            while(s1Index != s1.length() && s1.charAt(s1Index) == s3.charAt(s1Index + s2Index)) s1Index++;
            return dp[s1Index][s2Index] = (s1Index == s1.length() ? true : false);
        }

        if(s3.charAt(s1Index+s2Index) == s1.charAt(s1Index) && s3.charAt(s1Index+s2Index) == s2.charAt(s2Index)) {
            return dp[s1Index][s2Index] = func(s1,s1Index+1,s2,s2Index,s3) | func(s1,s1Index,s2,s2Index+1,s3);
        }

        if(s3.charAt(s1Index+s2Index) == s1.charAt(s1Index)) return dp[s1Index][s2Index] = func(s1,s1Index+1,s2,s2Index,s3);
        if(s3.charAt(s1Index+s2Index) == s2.charAt(s2Index)) return dp[s1Index][s2Index] = func(s1,s1Index,s2,s2Index+1,s3);
        return dp[s1Index][s2Index] = false;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length()) return false;
        for(int i=0; i<=s1.length(); i++) {
            for(int j=0; j<=s2.length(); j++) {
                isVisited[i][j] = false;
            }
        }
        return func(s1,0,s2,0,s3);
    }
}
