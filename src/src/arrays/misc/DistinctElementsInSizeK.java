package arrays.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DistinctElementsInSizeK {
    ArrayList<Integer> countDistinct(int A[], int n, int k)
    {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int noOfDistinct = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<k; i++) {
            if(mp.containsKey(A[i]) == false) {
                noOfDistinct++;
                mp.put(A[i],1);
            }
            else {
                mp.put(A[i], mp.get(A[i])+1);
            }
        }
        ans.add(noOfDistinct);
        for(int i=k; i<n; i++) {
            //Add ith index and remove i-k index
            if(mp.containsKey(A[i]) == false || mp.get(A[i]) == 0) {
                noOfDistinct++;
                mp.put(A[i],1);
            }
            else {
                mp.put(A[i], mp.get(A[i])+1);
            }

            mp.put(A[i-k], mp.get(A[i-k])-1);
            if(mp.get(A[i-k])==0) noOfDistinct--;

            ans.add(noOfDistinct);
        }
        return ans;
    }
}
