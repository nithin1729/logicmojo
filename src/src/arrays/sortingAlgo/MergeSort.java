package arrays.sortingAlgo;

public class MergeSort {

    private void merge(int[] arr, int leftIndex, int mid, int rightIndex) {
        int[] temp = new int[rightIndex-leftIndex+1];
        int i=leftIndex;
        int j=mid+1;
        int k=0;

        while(i<=mid && j<=rightIndex) {
            if(arr[i]<arr[j]) {
                temp[k++] = arr[i++];
            }
            else {
                temp[k++] = arr[j++];
            }
        }
        while(i<=mid) {
            temp[k++] = arr[i++];
        }
        while(j<=rightIndex) {
            temp[k++] = arr[j++];
        }
        for(i=0; i<temp.length; i++) {
            arr[leftIndex+i]=temp[i];
        }
    }

    public void mergeSort(int[] arr, int leftIndex, int rightIndex) {
        if(leftIndex < rightIndex) {
            int mid = leftIndex + (rightIndex-leftIndex)/2;
            mergeSort(arr,leftIndex,mid);
            mergeSort(arr,mid+1,rightIndex);
            merge(arr,leftIndex,mid,rightIndex);
        }
    }
}
