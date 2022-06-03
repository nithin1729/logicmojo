package arrays.misc;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowString {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        for(int i=0; i<t.length(); i++) {
            if(!tMap.containsKey(t.charAt(i))) tMap.put(t.charAt(i),0);
            tMap.put(t.charAt(i), tMap.get(t.charAt(i))+1);
        }
        Map<Character, Integer> sMap = new HashMap<>();
        int currSize = 0;
        int currIndex=0;
        int startIndex=0;
        int start=0;
        int ansLength = s.length()+1;
        while(currIndex < s.length()) {
            if(!sMap.containsKey(s.charAt(currIndex))) sMap.put(s.charAt(currIndex), 0);
            sMap.put(s.charAt(currIndex), sMap.get(s.charAt(currIndex))+1);
            if(tMap.containsKey(s.charAt(currIndex)) && sMap.get(s.charAt(currIndex))<=tMap.get(s.charAt(currIndex))) {
                currSize++;
            }
            if(currSize==t.length()) {
                while(!tMap.containsKey(s.charAt(start)) || sMap.get(s.charAt(start)) > tMap.get(s.charAt(start))) {
                    sMap.put(s.charAt(start), sMap.get(s.charAt(start))-1);
                    if(sMap.get(s.charAt(start))==0) sMap.remove(s.charAt(start));
                    start++;
                }
                if(ansLength > currIndex-start+1) {
                    startIndex = start;
                    ansLength = currIndex-start+1;
                }
            }
            currIndex++;
        }
        if(ansLength==s.length()+1) return "";
        return s.substring(startIndex, startIndex+ansLength);
    }
}
