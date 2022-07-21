package backtracking;

import java.util.ArrayList;
import java.util.List;

public class NParanthesis {
    List<String> ans;

    private void func(char[] arr, int index, int open, int close) {
        if(index==arr.length) {
            ans.add(new String(arr));
            return;
        }
        if(open==0) {
            arr[index] = ')';
            func(arr,index+1,open,close-1);
            return;
        }
        arr[index] = '(';
        func(arr,index+1,open-1,close);

        if(open != close) {
            arr[index] = ')';
            func(arr, index+1, open, close-1);
        }
    }

    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        char[] arr = new char[2*n];
        func(arr,0,n,n);
        return ans;
    }
}
