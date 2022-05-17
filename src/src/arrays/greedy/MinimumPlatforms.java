package arrays.greedy;
import java.util.Arrays;

public class MinimumPlatforms {
    public int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);

        int i=0, j=0;
        int ans = 0, curr = 0;
        while(i<arr.length && j<dep.length) {
            if(arr[i] <= dep[j]) {
                curr++;
                i++;
                ans = Math.max(ans, curr);
            }
            else {
                curr--;
                j++;
            }
        }
        return ans;
    }
}
