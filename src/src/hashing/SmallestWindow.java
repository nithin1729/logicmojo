package hashing;

import java.util.HashMap;
import java.util.Map;

public class SmallestWindow {
    public static String smallestWindow(String s, String p)
    {
        // Your code here
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for(int i=0; i<p.length(); i++) {
            if(!map2.containsKey(p.charAt(i))) map2.put(p.charAt(i),1);
            else map2.put(p.charAt(i), map2.get(p.charAt(i))+1);
        }

        int requiredCount = p.length();
        int currCount = 0;
        int left = 0, right = -1;
        String ans = "-1";
        int ansLen = 100005;

        while(right < s.length()) {
            if(currCount < requiredCount) {
                right++;
                if(right < s.length()) {
                    if(!map1.containsKey(s.charAt(right))) map1.put(s.charAt(right),1);
                    else map1.put(s.charAt(right), map1.get(s.charAt(right))+1);

                    int map2Count = map2.containsKey(s.charAt(right))?map2.get(s.charAt(right)):0;
                    if(map1.get(s.charAt(right)) <= map2Count) currCount++;
                }
            }
            else {
                map1.put(s.charAt(left), map1.get(s.charAt(left))-1);
                int map2Count = map2.containsKey(s.charAt(left))?map2.get(s.charAt(left)):0;
                if(map1.get(s.charAt(left)) < map2Count) currCount--;
                left++;
            }

            if(currCount==requiredCount) {
                if(right-left+1 < ansLen) {
                    ansLen = right-left+1;
                    ans = s.substring(left, left+ansLen);
                }
            }
        }
        return ans;
    }
}
