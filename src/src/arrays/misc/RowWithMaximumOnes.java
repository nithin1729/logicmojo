package arrays.misc;

public class RowWithMaximumOnes {
    private static int findOnes(int[] arr) {
        int index = arr.length;
        int left = 0, right = arr.length-1;
        while(left<=right) {
            int mid = left + (right-left)/2;
            if(arr[mid]==1) {
                index = mid;
                right = mid-1;
            }
            else {
                left = mid+1;
            }
        }
        return arr.length-index;
    }
    public static int maxOnes (int Mat[][], int N, int M)
    {
        // your code here
        int ans = 0;
        int ansIndex = 0;
        for(int i=0; i<N; i++) {
            int temp = findOnes(Mat[i]);
            if(temp > ans) {
                ans = temp;
                ansIndex = i;
            }
        }
        return ansIndex;
    }
}
