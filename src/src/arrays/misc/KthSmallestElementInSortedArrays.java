package arrays.misc;

public class KthSmallestElementInSortedArrays {
    public long kthElement( int nums1[], int nums2[], int n, int m, int k) {
        if(n>m) return kthElement(nums2,nums1,m,n,k);
        int targetElements = k;
        int left=0, right = nums1.length-1;
        while(left<=right) {
            int mid = left + (right-left)/2;

            int firstArrayLeftSize = mid+1;
            int secondArrayLeftSize = targetElements-firstArrayLeftSize;
            if(secondArrayLeftSize>m) {
                left = mid + 1;
                continue;
            }
            if(secondArrayLeftSize < 0) {
                right = mid-1;
                continue;
            }

            int firstLeftElement = firstArrayLeftSize-1>=0? nums1[firstArrayLeftSize-1]: Integer.MIN_VALUE;
            int firstRightElement = firstArrayLeftSize<nums1.length? nums1[firstArrayLeftSize]: Integer.MAX_VALUE;
            int secondLeftElement = secondArrayLeftSize-1>=0? nums2[secondArrayLeftSize-1]: Integer.MIN_VALUE;
            int secondRightElement = secondArrayLeftSize<nums2.length? nums2[secondArrayLeftSize]: Integer.MAX_VALUE;

            if(firstLeftElement<=secondRightElement && secondLeftElement<=firstRightElement) {
                //found the partition
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
        return Math.max(firstLeftElement,secondLeftElement);
    }
}
