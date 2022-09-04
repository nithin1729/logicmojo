package dynamicprogramming;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        // (m+n-2)C(m-1)
        if(m>n) {
            m = m ^ n;
            n = m ^ n;
            m = m ^ n;
        }
        m--;
        n--;
        long ans = 1;
        for(int i=1; i<=m; i++) {
            ans = ans * (n+i);
            ans = ans / i;
        }
        return (int)ans;
    }
}
