package arrays.misc;

public class DuplicatesRemovalString {
    public String removeDuplicates(String str) {
        boolean[] isPresent = new boolean[26];
        for(int i=0; i<isPresent.length; i++) isPresent[i] = false;
        for(int i=0; i<str.length(); i++) isPresent[str.charAt(i)-'a'] = true;
        String ans = "";
        for(int i=0; i<str.length(); i++) {
            if(isPresent[str.charAt(i) - 'a']) {
                ans += str.charAt(i);
                isPresent[str.charAt(i)-'a'] = false;
            }
        }
        return ans;
    }
}
