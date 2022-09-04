package dynamicprogramming;

public class NCRModPUsingFermetsLittleTheorem {
    static long[] fact = new long[100001];
    static int p = 1000000007;
    static boolean isComputed = false;

    static long computePower(long num, int pow) {
        if(pow == 0) return 1;
        if(pow == 1) return num;

        if(pow%2 == 0) {
            long ans = computePower(num, pow/2);
            ans = ans*ans;
            return ans%p;
        }
        long ans = num;
        ans *= computePower(num, pow-1);
        return ans%p;
    }

    static long ncr(int n, int r){
        //complete the function here
        if(n<r) return 0;
        if(isComputed == false) {
            isComputed = true;
            fact[0] = 1;
            for(int i=1; i<=100000; i++) {
                fact[i] = fact[i-1];
                fact[i] = i*fact[i];
                fact[i] = fact[i] % p;
            }
        }
        long ans = fact[n];
        ans = ans * computePower(fact[r], p-2);
        ans = ans % p;
        ans = ans * computePower(fact[n-r], p-2);
        ans = ans % p;
        return (int)ans;
    }
}
