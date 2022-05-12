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
}
