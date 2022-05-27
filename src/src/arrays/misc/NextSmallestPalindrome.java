package arrays.misc;

public class NextSmallestPalindrome {
    private boolean isAllNine(String s) {
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)!='9') return false;
        }
        return true;
    }

    private String increment(String str, int index, int carry) {
        String ans = "";
        for(int i=index; i>=0; i--) {
            if(carry==1) {
                if(str.charAt(i)=='9') {
                    ans = '0' + ans;
                }
                else {
                    char c = (char)(str.charAt(i) + 1);
                    carry = 0;
                    ans = c + ans;
                }
            }
            else ans = str.charAt(i) + ans;
        }
        return ans;
    }

    public String solve(String A) {
        if(isAllNine(A)) {
            String ans = "1";
            for(int i=0; i<A.length()-1; i++) ans = ans + '0';
            ans = ans + '1';
            return ans;
        }
        int leftIndex=A.length()/2-1;
        int rightIndex=A.length()/2 + (A.length()%2);
        while(leftIndex>=0 && A.charAt(leftIndex) == A.charAt(rightIndex)) {
            leftIndex--;
            rightIndex++;
        }
        boolean isLeftMore = false;
        if(leftIndex!= -1 && A.charAt(leftIndex) > A.charAt(rightIndex)) isLeftMore = true;
        String ans;
        if(!isLeftMore) {
            ans = increment(A, A.length()/2-1+(A.length()%2), 1);
        }
        else ans = increment(A, A.length()/2-1+(A.length()%2), 0);
        int index = ans.length()-1-(A.length()%2);
        while(index>=0) {
            ans = ans + ans.charAt(index);
            index--;
        }
        return ans;
    }
}
