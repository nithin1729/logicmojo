package hashing;

import java.util.*;

public class AnagramsGroup {
    private String sortString(String str) {
        char[] temp = str.toCharArray();
        Arrays.sort(temp);
        return new String(temp);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for(int i=0; i<strs.length; i++) {
            String temp = sortString(strs[i]);
            List<String> val;
            if(!map.containsKey(temp)) {
                val = new ArrayList<>();
            }
            else {
                val = map.get(temp);
            }
            val.add(strs[i]);
            map.put(temp, val);
        }
        Set<String> set = map.keySet();
        for(String str: set) ans.add(map.get(str));
        return ans;
    }
}
