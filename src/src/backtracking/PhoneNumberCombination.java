package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumberCombination {
    List<String> ans;
    String[] letters = {" ", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private void func(String digits, int currIndex, char[] temp) {
        if(currIndex == digits.length()) {
            ans.add(new String(temp));
            return;
        }
        String possibleChar = letters[digits.charAt(currIndex) - '0'];
        for(int i=0; i<possibleChar.length(); i++) {
            temp[currIndex] = possibleChar.charAt(i);
            func(digits, currIndex+1, temp);
        }
    }
    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        char[] temp = new char[digits.length()];
        if(digits.length()==0) return ans;
        func(digits,0, temp);
        return ans;
    }
}
