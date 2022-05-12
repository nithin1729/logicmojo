import arrays.BitonicArrayMaximum;
import arrays.searchingAlgo.BinarySearch;
import arrays.searchingAlgo.LinearSearch;
import arrays.sortingAlgo.MergeSort;

public class MainMethod {
    public static void main(String[] args) {
        LinearSearch linearSearchObj = new LinearSearch();
        int[] unsortedArr = {8,1,2,7,3,5,4,6};
        System.out.println(linearSearchObj.linearSearch(unsortedArr, 5));

        BinarySearch binarySearchObj = new BinarySearch();
        int[] sortedArr = {1,2,3,4,5,6,7,8};
        System.out.println(binarySearchObj.modifiedBinarySearch(sortedArr, 7, 0, sortedArr.length-1));
        int[] sortedRotatedArr = {4,5,6,7,0,1,2};
        System.out.println(binarySearchObj.modifiedBinarySearch(sortedRotatedArr,0,0,sortedRotatedArr.length-1));
        System.out.println(binarySearchObj.modifiedBinarySearch(sortedRotatedArr,3,0,sortedRotatedArr.length-1));

        MergeSort mergeSortObj = new MergeSort();
        mergeSortObj.mergeSort(unsortedArr, 0, unsortedArr.length-1);
        for(int ele: unsortedArr) {
            System.out.print(ele + " ");
        }
        System.out.println();

        BitonicArrayMaximum bitonicArrayMaximumObj = new BitonicArrayMaximum();
        int[] arr = {1,15,25,45,42,21,17,12,11};
        System.out.println(bitonicArrayMaximumObj.getMaximum(arr));
    }
}
