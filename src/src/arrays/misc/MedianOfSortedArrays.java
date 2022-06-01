package arrays.misc;

public class MedianOfSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length) return findMedianSortedArrays(nums2,nums1);

        int targetElements = (nums1.length + nums2.length + 1)/2;
        boolean isEvenLength = (nums1.length+nums2.length)%2==0?true:false;
        int left=0, right = nums1.length-1;
        while(left<=right) {
            int mid = left + (right-left)/2;

            int firstArrayLeftSize = mid+1;
            int secondArrayLeftSize = targetElements-firstArrayLeftSize;

            int firstLeftElement = firstArrayLeftSize-1>=0? nums1[firstArrayLeftSize-1]: Integer.MIN_VALUE;
            int firstRightElement = firstArrayLeftSize<nums1.length? nums1[firstArrayLeftSize]: Integer.MAX_VALUE;
            int secondLeftElement = secondArrayLeftSize-1>=0? nums2[secondArrayLeftSize-1]: Integer.MIN_VALUE;
            int secondRightElement = secondArrayLeftSize<nums2.length? nums2[secondArrayLeftSize]: Integer.MAX_VALUE;

            if(firstLeftElement<=secondRightElement && secondLeftElement<=firstRightElement) {
                //found the partition
                if(isEvenLength) {
                    return (Math.max(firstLeftElement,secondLeftElement) + Math.min(firstRightElement,secondRightElement))/2.0;
                }
                return Math.max(firstLeftElement,secondLeftElement);
            }

            if(firstLeftElement>secondRightElement) {
                right = mid-1;
            }
            else {
                left=mid+1;
            }
        }
        int firstArrayLeftSize = left;
        int secondArrayLeftSize = targetElements-firstArrayLeftSize;

        int firstLeftElement = firstArrayLeftSize-1>=0? nums1[firstArrayLeftSize-1]: Integer.MIN_VALUE;
        int firstRightElement = firstArrayLeftSize<nums1.length? nums1[firstArrayLeftSize]: Integer.MAX_VALUE;
        int secondLeftElement = secondArrayLeftSize-1>=0? nums2[secondArrayLeftSize-1]: Integer.MIN_VALUE;
        int secondRightElement = secondArrayLeftSize<nums2.length? nums2[secondArrayLeftSize]: Integer.MAX_VALUE;

        if(isEvenLength) {
            return (Math.max(firstLeftElement,secondLeftElement) + Math.min(firstRightElement,secondRightElement))/2.0;
        }
        return Math.max(firstLeftElement,secondLeftElement);
    }
}
