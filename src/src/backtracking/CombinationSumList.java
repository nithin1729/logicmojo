package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumList {
    List<List<Integer>> ans;

    private void func(int[] candidates, int target, int index, List<Integer> curr) {
        if(target==0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(index == candidates.length || candidates[index] > target) return;
        int count = 0;
        while(count*candidates[index] <= target) {
            for(int i=0; i<count; i++) curr.add(candidates[index]);
            func(candidates, target-count*candidates[index], index+1, curr);
            for(int i=0; i<count; i++) curr.remove(curr.size()-1);
            count++;
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        func(candidates, target, 0, curr);
        return ans;
    }
}
