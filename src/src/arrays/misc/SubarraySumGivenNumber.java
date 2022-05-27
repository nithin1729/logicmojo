package arrays.misc;

import java.util.HashMap;

public class SubarraySumGivenNumber {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        int ans = 0;
        int curr = 0;
        for(int i=0; i<nums.length; i++) {
            curr += nums[i];
            if(mp.containsKey(curr-k)) {
                ans += mp.get(curr-k);
            }

            if(mp.containsKey(curr) == false) mp.put(curr,0);

            mp.put(curr, mp.get(curr)+1);
        }
        return ans;
    }
}
