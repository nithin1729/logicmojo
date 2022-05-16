package arrays.partitionAlgo;

public class DuplicatesRemovalSortedArray {
    public int removeDuplicates(int[] arr) {
        int pIndex = 0;
        int prev = arr[0]-1;

        for(int i=0; i<arr.length; i++) {
            if(arr[i]!= prev) {
                arr[pIndex++] = arr[i];
            }
            prev = arr[i];
        }
        return pIndex;
    }
}
