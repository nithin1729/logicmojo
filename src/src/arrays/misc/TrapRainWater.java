package arrays.misc;

public class TrapRainWater {
    public int trap(int[] height) {
        int leftMax=0, rightMax=0;

        int left=0, right=height.length-1;
        int ans =0;
        while(left<=right) {
            if(height[left]<height[right]) {
                ans += (leftMax - height[left]) > 0? leftMax - height[left]: 0;
                leftMax = Math.max(leftMax, height[left]);
                left++;
            }
            else {
                ans += (rightMax - height[right]) > 0? rightMax - height[right]: 0;
                rightMax = Math.max(rightMax, height[right]);
                right--;
            }
        }
        return ans;
    }
}
