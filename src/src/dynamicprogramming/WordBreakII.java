package dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreakII {
    List<String> ans = new ArrayList<>();

    private void func(String str, int currIndex, List<String> stack, Map<String, Boolean> map) {
        if(currIndex == str.length()) {
            ans.add(String.join(" ", stack));
            return;
        }
        String curr = "";
        for(int i=currIndex; i<str.length(); i++) {
            curr = curr + str.charAt(i);
            if(map.containsKey(curr)) {
                stack.add(curr);
                func(str,i+1,stack,map);
                stack.remove(stack.size()-1);
            }
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        ans.clear();
        List<String> stack = new ArrayList<>();
        Map<String, Boolean> map = new HashMap<>();
        for(String str: wordDict) map.put(str, true);
        func(s,0,stack,map);
        return ans;
    }
}
