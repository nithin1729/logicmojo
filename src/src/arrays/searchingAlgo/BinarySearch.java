package arrays.searchingAlgo;

public class BinarySearch {
    public int binarySearch(int[] arr, int ele, int firstIndex, int lastIndex) {
        if(firstIndex>lastIndex) {
            return -1;
        }
        int mid = firstIndex + (lastIndex-firstIndex)/2;
        if(arr[mid] == ele) {
            return mid;
        }
        if(arr[mid] > ele) {
            return binarySearch(arr, ele, firstIndex, mid-1);
        }
        return binarySearch(arr, ele, mid+1, lastIndex);
    }

    public int modifiedBinarySearch(int[] arr, int ele, int leftIndex, int rightIndex) {
        if(leftIndex>rightIndex) {
            return -1;
        }
        int mid = leftIndex + (rightIndex-leftIndex)/2;
        if(arr[mid]==ele) {
            return mid;
        }
        if(arr[leftIndex]<=arr[mid]) {
            //left is sorted
            if(arr[leftIndex]<=ele && ele<=arr[mid]) {
                return modifiedBinarySearch(arr,ele,leftIndex,mid-1);
            }
            return modifiedBinarySearch(arr,ele,mid+1,rightIndex);
        }
        //right is sorted
        if(arr[mid]<=ele && ele<=arr[rightIndex]) {
            return modifiedBinarySearch(arr,ele,mid+1,rightIndex);
        }
        return modifiedBinarySearch(arr,ele,leftIndex,mid-1);
    }

    private int func(int[] arr, int start, int end) {
        if(arr[start]<=arr[end]) {
            return start;
        }
        if(end==start+1) {
            if(arr[start]<arr[end]) {
                return start;
            }
            return end;
        }
        int mid = start + (end-start)/2;
        if(arr[mid]<arr[mid+1] && arr[mid]<arr[mid-1]) {
            return mid;
        }
        if(arr[start]<=arr[mid]) {
            return func(arr,mid+1,end);
        }
        return func(arr,start,mid-1);
    }

    public int minElementSortedRotatedArray(int[] arr) {
        return func(arr,0,arr.length-1);
    }
}
