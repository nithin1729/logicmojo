package graphs;

import java.util.HashSet;
import java.util.Set;

public class WordBoggle {
    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        boolean isEnd;
        String word;

        TrieNode() {
            isEnd = false;
            for(int i=0; i<26; i++) child[i] = null;
        }
    }
    Set<String> ans = new HashSet<>();

    private TrieNode insertTrie(TrieNode root, String word) {
        if(root==null) root = new TrieNode();
        TrieNode child = root;
        for(int i=0; i<word.length(); i++) {
            if(child.child[word.charAt(i) - 'A'] == null) child.child[word.charAt(i) - 'A'] = new TrieNode();
            child = child.child[word.charAt(i) - 'A'];
        }
        child.isEnd = true;
        child.word = word;
        return root;
    }

    private void searchWord(char[][] board, int row, int col, TrieNode root) {
        if(root == null) return;
        if(root.isEnd) {
            ans.add(root.word);
        }
        int[] x = {-1,1,0,0,-1,-1,1,1};
        int[] y = {0,0,-1,1,-1,1,-1,1};
        char ch = board[row][col];
        board[row][col] = '$';

        for(int i=0; i<x.length; i++) {
            int currX = row + x[i];
            int currY = col + y[i];

            if(currX>=0 && currX<board.length && currY>=0 && currY<board[currX].length && board[currX][currY] != '$'
                    && root.child[board[currX][currY] - 'A'] != null) {

                searchWord(board, currX, currY, root.child[board[currX][currY] - 'A']);
            }
        }

        board[row][col] = ch;
    }

    public String[] wordBoggle(char board[][], String[] dictionary)
    {
        // Write your code here
        TrieNode root = new TrieNode();
        for(int i=0; i<dictionary.length; i++) {
            root = insertTrie(root, dictionary[i]);
        }
        ans.clear();
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if(root.child[board[i][j] - 'A'] != null) {
                    searchWord(board, i, j, root.child[board[i][j] - 'A']);
                }
            }
        }
        String[] finalAns = new String[ans.size()];
        int currIndex = 0;
        for(String s: ans) {
            finalAns[currIndex++] = s;
        }
        return finalAns;
    }
}
