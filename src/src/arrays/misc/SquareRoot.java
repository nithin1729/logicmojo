package arrays.misc;

public class SquareRoot {
    public int mySqrt(int x) {
        long temp = x;
        long ans = 0;
        long left = 0, right = x;
        while(left<=right) {
            long mid = (left+right)/2;
            if(mid*mid == temp) return (int)mid;
            if(mid*mid > temp) {
                right = mid-1;
            }
            else {
                ans = mid;
                left = mid+1;
            }
        }
        return (int)ans;
    }
}
