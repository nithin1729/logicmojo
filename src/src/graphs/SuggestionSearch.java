package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SuggestionSearch {
    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        boolean isEnd;
        String[] words = new String[3];
        int strCount;

        TrieNode() {
            for(int i=0; i<26; i++) {
                child[i] = null;
            }
            isEnd = false;
            strCount = 0;
        }
    }

    private void addStrings(TrieNode root, String curr, List<String> ans) {
        if(root==null || ans.size() >= 3) return;
        if(root.isEnd) ans.add(curr);

        for(int i=0; i<root.child.length && ans.size()<3; i++) {
            if(root.child[i] != null) {
                addStrings(root.child[i],curr + (char)((int)'a' + i),ans);
            }
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = new TrieNode();
        Arrays.sort(products);
        for(int i=0; i<products.length; i++) {
            String currStr = products[i];

            TrieNode curr = root;
            if(curr.strCount < 3) curr.words[curr.strCount++] = products[i];
            for(int j=0; j<currStr.length(); j++) {
                if(curr.child[currStr.charAt(j)-'a'] == null) curr.child[currStr.charAt(j)-'a'] = new TrieNode();
                curr = curr.child[currStr.charAt(j)-'a'];
                if(curr.strCount < 3) curr.words[curr.strCount++] = products[i];
            }
            curr.isEnd = true;
        }

        TrieNode curr = root;
        List<List<String>> ans = new ArrayList<>();

        for(int i=0; i<searchWord.length(); i++) {
            if(curr == null || curr.child[searchWord.charAt(i)-'a'] == null) {
                ans.add(new ArrayList<String>());
                curr = null;
                continue;
            }
            curr = curr.child[searchWord.charAt(i)-'a'];
            List<String> suggestedStr = new ArrayList<>();
            for(int j=0; j<curr.strCount; j++) suggestedStr.add(curr.words[j]);
            ans.add(suggestedStr);
        }

        return ans;
    }
}
