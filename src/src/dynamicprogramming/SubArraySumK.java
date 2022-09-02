package dynamicprogramming;

public class SubArraySumK {
    static boolean[][] dp = new boolean[101][100001];
    static boolean[][] isVisited = new boolean[101][100001];

    private static Boolean func(int[] arr, int index, int sum) {
        if(isVisited[index][sum] == true) return dp[index][sum];
        isVisited[index][sum] = true;
        if(sum == 0) return dp[index][sum] = true;
        if(index == arr.length) return dp[index][sum] = false;
        if(sum >= arr[index] && func(arr, index+1, sum-arr[index])) return dp[index][sum] = true;
        return dp[index][sum] = func(arr, index+1, sum);
    }

    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        for(int i=0; i<=N; i++) for(int j=0; j<=sum; j++) isVisited[i][j] = false;
        return func(arr,0,sum);
    }
}
