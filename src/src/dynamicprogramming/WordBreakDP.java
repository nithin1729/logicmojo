package dynamicprogramming;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class WordBreakDP {
    boolean[] dp = new boolean[301];
    boolean[] isCalculated = new boolean[301];

    private boolean func(String s, int currIndex, Map<String, Boolean> map) {
        if(isCalculated[currIndex] == true) return dp[currIndex];
        isCalculated[currIndex] = true;
        if(currIndex == s.length()) return dp[currIndex] = true;
        String curr = "";

        for(int i=currIndex; i<s.length(); i++) {
            curr = curr + s.charAt(i);
            if(map.containsKey(curr) && func(s,i+1,map)) return dp[currIndex] = true;
        }
        return dp[currIndex] = false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        for(int i=0; i<=s.length(); i++) isCalculated[i] = false;
        Map<String, Boolean> map = new HashMap<>();
        for(String str: wordDict) map.put(str, true);
        return func(s,0,map);
    }
}
