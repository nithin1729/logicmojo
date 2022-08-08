package fbleetcode;

import java.util.HashMap;
import java.util.Map;

public class AlienDictionary {
    Map<Character, Integer> map;

    private boolean isGreater(String first, String second) {
        // leetcode 953
        int index = 0;

        while(index < first.length() && index < second.length()) {
            if(map.get(first.charAt(index)) > map.get(second.charAt(index))) {
                return true;
            }
            if(map.get(first.charAt(index)) < map.get(second.charAt(index))) {
                return false;
            }

            index++;
        }

        if(first.length() > second.length()) return true;
        return false;
    }
    public boolean isAlienSorted(String[] words, String order) {
        map = new HashMap<>();
        for(int i=0; i<order.length(); i++) map.put(order.charAt(i), i);

        for(int i=1; i<words.length; i++) {
            if(isGreater(words[i-1], words[i])) return false;
        }
        return true;
    }
}
