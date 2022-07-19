package hashing;

import java.util.*;

public class FourSum {
    class Point {
        int a;
        int b;
        int c;
        int d;

        Point(int a, int b, int c, int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }

        @Override
        public boolean equals(Object p1) {
            Point p = (Point)p1;
            if(this.a == p.a &&
                    this.b == p.b &&
                    this.c == p.c &&
                    this.d == p.d) return true;
            return false;
        }

        @Override
        public int hashCode() {
            return this.a + this.b + this.c + this.d;
        }
    }
    public List<List<Integer>> fourSum(int[] nums, int targett) {
        long target = targett;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        Set<Point> set = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                int left = j+1;
                int right = nums.length - 1;

                while(left<right) {
                    long val = nums[i];
                    val = val + nums[j] + nums[left] + nums[right];
                    if(val == target) {
                        set.add(new Point(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                    }
                    else if(val < target) left++;
                    else right--;
                }
            }
        }
        for(Point p: set) {
            List<Integer> curr = new ArrayList<>();
            curr.add(p.a);
            curr.add(p.b);
            curr.add(p.c);
            curr.add(p.d);
            ans.add(curr);
        }
        return ans;
    }
}
