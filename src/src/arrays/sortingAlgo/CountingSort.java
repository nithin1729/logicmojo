package arrays.sortingAlgo;

public class CountingSort {
    public void sortArray_0_1_2(int[] arr) {
        int[] count = {0,0,0};
        for(int i=0; i<arr.length; i++) {
            count[arr[i]]++;
        }
        int k=0;
        for(int i=0; i<3; i++) {
            while(count[i]-- > 0) {
                arr[k++] = i;
            }
        }
    }
}
