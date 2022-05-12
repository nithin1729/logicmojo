package arrays;

public class BitonicArrayMaximum {

    private int search(int[] arr, int leftIndex, int rightIndex) {
        if(rightIndex==leftIndex) {
            return arr[leftIndex];
        }
        if(rightIndex==leftIndex+1) {
            return Math.max(arr[leftIndex],arr[rightIndex]);
        }
        int mid = leftIndex + (rightIndex-leftIndex)/2;
        if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]) {
            return arr[mid];
        }
        if(arr[mid-1]<arr[mid] && arr[mid]<arr[mid+1]) {
            return search(arr,mid+1,rightIndex);
        }
        return search(arr,leftIndex,mid-1);
    }
    public int getMaximum(int[] arr) {
        return search(arr,0,arr.length-1);
    }
}
