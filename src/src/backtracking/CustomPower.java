package backtracking;

public class CustomPower {
    private double myPoww(double x, long n) {
        if(n==0 || x==1) return 1;
        if(n<0) return myPoww(1/x, -n);
        if(n%2==1) return x * myPoww(x,n-1);
        double ans = myPoww(x,n/2);
        return ans*ans;
    }
    public double myPow(double x, int n) {
        return myPoww(x,n);
    }
}
