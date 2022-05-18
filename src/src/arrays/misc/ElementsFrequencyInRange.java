package arrays.misc;

public class ElementsFrequencyInRange {
    public void countFrequency(int[] arr) {
        // Elements range from 1 to n where n is size of array
        int n = arr.length;
        for(int i=0; i< arr.length; i++) arr[i]--;
        for(int i=0; i<arr.length; i++) {
            int num = arr[i]%n;
            arr[num] += n;
        }
        for(int i=0; i<arr.length; i++) {
            System.out.println((i+1) + " : " + arr[i]/n);
        }
    }
}
