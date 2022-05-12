package arrays;

public class LinearSearch {
    public static int linearSearch(int[] arr, int ele) {
        for(int i=0; i<arr.length; i++) {
            if(arr[i]==ele) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {8,1,3,7,2,6,4,5};
        System.out.println(linearSearch(arr,5));
    }
}
