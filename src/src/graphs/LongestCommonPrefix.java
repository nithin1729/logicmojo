package graphs;

public class LongestCommonPrefix {
    String longestCommonPrefix(String arr[], int n){
        // code here
        String smallest = arr[0];
        String largest = arr[0];

        for(int i=1; i<arr.length; i++) {
            if(smallest.compareTo(arr[i]) > 0) smallest = arr[i];
            if(largest.compareTo(arr[i]) < 0) largest = arr[i];
        }

        int ans = 0;
        while(ans < smallest.length() && ans < largest.length() && smallest.charAt(ans) == largest.charAt(ans)) {
            ans++;
        }
        if(ans==0) return "-1";
        return smallest.substring(0,ans);
    }
}
