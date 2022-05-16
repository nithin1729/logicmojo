package arrays.partitionAlgo;

public class PartitionZeroToEnd {
    public void partitionZeroToEnd(int[] arr) {
        int pIndex=0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[pIndex];
                arr[pIndex] = temp;
                pIndex++;
            }
        }
    }
}
