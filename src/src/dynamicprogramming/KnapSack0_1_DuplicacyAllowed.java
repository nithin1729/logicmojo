package dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;

public class KnapSack0_1_DuplicacyAllowed {
    static class WeightValue {
        int weight;
        int value;

        WeightValue(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        WeightValue[] temp = new WeightValue[N];
        for(int i=0; i<N; i++) temp[i] = new WeightValue(wt[i], val[i]);
        Arrays.sort(temp, new Comparator<WeightValue>() {
            @Override
            public int compare(WeightValue o1, WeightValue o2) {
                if(o1.weight < o2.weight) return -1;
                return 1;
            }
        });
        for(int i=0; i<N; i++) {
            wt[i] = temp[i].weight;
            val[i] = temp[i].value;
        }
        int[] dp = new int[W+1];
        dp[0] = 0;
        for(int weight = 1; weight <= W; weight++) {
            dp[weight] = 0;
            for(int i=0; i<wt.length && wt[i] <= weight; i++) {
                dp[weight] = Math.max(dp[weight], val[i] + dp[weight-wt[i]]);
            }
        }
        return dp[W];
    }
}
