package stacksqueues;

public class ReverseStringWords {
    public String reverseWords(String s) {
        String[] splitStr = s.split("\\s+");
        String ans = "";
        for(int i=splitStr.length-1; i>=0; i--) {
            if(splitStr[i].length() > 0) ans = ans + splitStr[i] + " ";
        }
        return ans.trim();
    }
}
