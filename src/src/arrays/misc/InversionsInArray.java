package arrays.misc;

public class InversionsInArray {
    private static long merge(long[] arr, int left, int mid, int right) {
        long[] temp1 = new long[mid-left+1];
        long[] temp2 = new long[right-mid];
        for(int i=left; i<=mid; i++) temp1[i-left] = arr[i];
        for(int i=mid+1; i<=right; i++) temp2[i-mid-1] = arr[i];

        long ans = 0;
        long[] temp = new long[right-left+1];
        int k=0;
        int i=0;
        int j=0;
        while(i<temp1.length && j<temp2.length) {
            if(temp1[i]<=temp2[j]) {
                temp[k++] = temp1[i++];
            }
            else {
                temp[k++] = temp2[j++];
                ans += temp1.length - i;
            }
        }
        while(i<temp1.length) {
            temp[k++] = temp1[i++];
        }
        while(j<temp2.length) {
            temp[k++] = temp2[j++];
        }
        for(i=left; i<=right; i++) arr[i] = temp[i-left];
        return ans;
    }
    private static long mergeSort(long[] arr, int left, int right) {
        long ans = 0;
        if(left<right) {
            int mid = (left+right)/2;
            ans = mergeSort(arr, left, mid);
            ans += mergeSort(arr, mid+1, right);
            ans += merge(arr, left, mid, right);
        }
        return ans;
    }

    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        return mergeSort(arr, 0, arr.length-1);
    }
}
