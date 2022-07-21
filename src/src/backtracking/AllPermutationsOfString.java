package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class AllPermutationsOfString {
    Set<String> ans;

    private void func(char[] arr, int index) {
        if(index == arr.length) {
            ans.add(new String(arr));
            return;
        }
        for(int i=index; i<arr.length; i++) {
            char temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
            func(arr, index+1);
            temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }

    public List<String> find_permutation(String S) {
        // Code here
        ans = new TreeSet<>();
        char[] arr = new char[S.length()];
        for(int i=0; i<S.length(); i++) arr[i] = S.charAt(i);
        func(arr,0);
        return new ArrayList<String>(ans);
    }
}
