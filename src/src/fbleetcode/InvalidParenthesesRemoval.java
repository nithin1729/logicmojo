package fbleetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class InvalidParenthesesRemoval {
    // leetcode 301
    Set<String> ans = new HashSet<>();

    private void func(String s, int currIndex, int openCount, int closeCount, int currCount, char[] arr, int arrIndex) {
        if(currIndex == s.length() && openCount==0 && closeCount==0 && currCount==0) {
            ans.add(new String(arr,0,arrIndex));
            return;
        }

        if(currCount < 0) return;

        if(currIndex == s.length()) {
            if(openCount != 0 || closeCount != 0 || currCount != 0) return;
        }

        if(s.charAt(currIndex) == '(') {
            if(openCount > 0) {
                func(s, currIndex+1, openCount-1, closeCount, currCount, arr, arrIndex);
            }
            arr[arrIndex] = '(';
            func(s, currIndex+1, openCount, closeCount, currCount+1, arr, arrIndex+1);
        }
        else if(s.charAt(currIndex) == ')') {
            if(closeCount > 0) {
                func(s, currIndex+1, openCount, closeCount-1, currCount, arr, arrIndex);
            }

            arr[arrIndex] = ')';
            func(s, currIndex+1, openCount, closeCount, currCount-1, arr, arrIndex+1);
        }
        else {
            arr[arrIndex] = s.charAt(currIndex);
            func(s, currIndex+1, openCount, closeCount, currCount, arr, arrIndex+1);
        }
    }

    public List<String> removeInvalidParentheses(String s) {
        int count = 0;
        int closeBrackets = 0;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') count++;
            else if(s.charAt(i) == ')') {
                count--;
                closeBrackets = Math.max(closeBrackets, -count);
            }
        }
        int openBrackets = count + closeBrackets;
        ans.clear();
        char[] arr = new char[s.length()];
        func(s,0,openBrackets,closeBrackets,0, arr, 0);

        return new LinkedList<String>(ans);
    }
}
