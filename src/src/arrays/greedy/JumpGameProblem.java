package arrays.greedy;

public class JumpGameProblem {
    public int minSteps(int[] arr) {
        int currSteps = arr[0];
        int currMax = arr[0];
        int ans = 1;

        for(int i=1; i<arr.length; i++) {
            if(i==arr.length-1) {
                return ans;
            }
            if(currSteps == 0) {
                return -1;
            }

            currSteps--;
            currMax--;

            currMax = Math.max(currMax, arr[i]);
            if(currSteps == 0) {
                currSteps = currMax;
                ans++;
            }
        }
        return ans;
    }
}
