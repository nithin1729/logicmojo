package arrays.misc;

public class MaximumIndexDifference {
    int maxIndexDiff(int arr[], int n) {
        // code here
        int[] leftMin = new int[n];
        leftMin[0] = 0;
        for(int i=1; i<n; i++) {
            leftMin[i] = arr[i]<arr[leftMin[i-1]]?i:leftMin[i-1];
        }
        int[] rightMax = new int[n];
        rightMax[n-1] = n-1;
        for(int i=n-2; i>=0; i--) {
            rightMax[i] = arr[i]>arr[rightMax[i+1]]?i:rightMax[i+1];
        }

        int leftIndex=0, rightIndex=0;
        int ans = -1;
        while(leftIndex<n && rightIndex<n) {
            if(arr[leftMin[leftIndex]] <= arr[rightMax[rightIndex]]) {
                ans = Math.max(ans, rightMax[rightIndex]-leftMin[leftIndex]);
                rightIndex++;
            }
            else {
                leftIndex++;
            }
        }
        return ans;
    }
}
