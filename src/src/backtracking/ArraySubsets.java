package backtracking;

import java.util.ArrayList;
import java.util.List;

public class ArraySubsets {
    List<List<Integer>> ans;

    private void func(int[] nums, int index, List<Integer> curr) {
        if(index == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        func(nums,index+1,curr);
        curr.add(nums[index]);
        func(nums,index+1,curr);
        curr.remove(curr.size()-1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        func(nums,0,curr);
        return ans;
    }
}
