package dynamicprogramming;

public class ClimbStairs {
    public int climbStairs(int n) {
        if(n<=2) return n;

        int temp1 = 1;
        int temp2 = 2;

        for(int i=3; i<=n; i++) {
            temp2 = temp2 + temp1;
            temp1 = temp2 - temp1;
        }
        return temp2;
    }
}
