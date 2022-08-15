package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlienDictionary {
    int index;

    private void dfs(Map<Character, List<Character>> map, char currChar, char[] ans, boolean[] visited) {
        visited[(int)currChar] = true;
        List<Character> nodes = map.get(currChar);
        for(int i=0; nodes != null && i<nodes.size(); i++) {
            if(visited[(int)nodes.get(i)] == false) {
                dfs(map, nodes.get(i), ans, visited);
            }
        }

        ans[index--] = currChar;
    }

    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        Map<Character, List<Character>> map = new HashMap<>();
        boolean[] visited = new boolean[256];
        for(int i=0; i<dict.length-1; i++) {
            String word1 = dict[i];
            String word2 = dict[i+1];

            for(int j=0; j<word1.length() && j<word2.length(); j++) {
                if(word1.charAt(j) != word2.charAt(j)) {
                    if(!map.containsKey(word1.charAt(j))) map.put(word1.charAt(j), new ArrayList<Character>());
                    map.get(word1.charAt(j)).add(word2.charAt(j));

                    break;
                }
            }
        }
        for(int i=0; i<256; i++) visited[i] = true;
        for(int i=0; i<dict.length; i++) for(int j=0; j<dict[i].length(); j++) visited[(int)dict[i].charAt(j)] = false;
        char[] ans = new char[K];
        index = K-1;

        for(int i=0; i<256; i++) {
            if(visited[i] == false) {
                dfs(map, (char)i, ans, visited);
            }
        }

        if(index != -1) {
            for(int i=0; i<256; i++) if(visited[i] == false) ans[index--] = (char)i;
        }
        //System.out.println(new String(ans));
        return new String(ans);
    }
}
