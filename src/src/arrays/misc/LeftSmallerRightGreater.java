package arrays.misc;

public class LeftSmallerRightGreater {
    public int findElement(int[] arr) {
        int[] minElements = new int[arr.length];
        minElements[arr.length-1] = Integer.MAX_VALUE;
        for(int i=arr.length-2; i>=0; i--) {
            minElements[i] = Math.min(minElements[i+1], arr[i+1]);
        }

        int leftMax = arr[0];
        for(int i=1; i<arr.length-1; i++) {
            if(arr[i] >= leftMax && arr[i] <= minElements[i]) return arr[i];
            leftMax = Math.max(leftMax, arr[i]);
        }
        return -1;
    }
}
