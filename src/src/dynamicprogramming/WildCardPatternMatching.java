package dynamicprogramming;

public class WildCardPatternMatching {
    boolean[][] dp = new boolean[2001][2001];
    boolean[][] isVisited = new boolean[2001][2001];

    private boolean func(String s, int sIndex, String p, int pIndex) {
        if(sIndex == -1 && pIndex == -1) return true;
        if(sIndex == -1) {
            for(int i=pIndex; i>=0; i--) if(p.charAt(i) != '*') return false;
            return true;
        }
        if(pIndex==-1) return false;
        if(isVisited[sIndex][pIndex] == true) return dp[sIndex][pIndex];
        isVisited[sIndex][pIndex] = true;
        if(s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '?') return dp[sIndex][pIndex] = func(s,sIndex-1,p,pIndex-1);
        if(p.charAt(pIndex) == '*') {
            for(int i=sIndex; i>=-1; i--) {
                if(func(s,i,p,pIndex-1)) return dp[sIndex][pIndex] = true;
            }
        }
        return dp[sIndex][pIndex] = false;
    }

    public boolean isMatch(String s, String p) {
        char[] str = new char[p.length()];
        boolean isLastStar = false;
        int index = 0;
        for(int i=0; i<p.length(); i++) {
            if(p.charAt(i) == '*') {
                if(isLastStar) continue;
                isLastStar = true;
            }
            else {
                isLastStar = false;
            }
            str[index++] = p.charAt(i);
        }
        p = new String(str,0,index);
        for(int i=0; i<=s.length(); i++) {
            for(int j=0; j<=p.length(); j++) {
                isVisited[i][j] = false;
            }
        }
        return func(s,s.length()-1,p,p.length()-1);
    }
}
