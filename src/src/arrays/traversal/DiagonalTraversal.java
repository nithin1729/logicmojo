package arrays.traversal;


import java.util.PriorityQueue;
import java.util.List;
import java.util.Comparator;

public class DiagonalTraversal {
    /*
        Given a 2D integer array nums, return all elements of nums in diagonal order as shown in the below images.

        Example 1:


        Input: nums = [[1,2,3],[4,5,6],[7,8,9]]
        Output: [1,4,2,7,5,3,8,6,9]
        Example 2:


        Input: nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]
        Output: [1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]

        Constraints:

        1 <= nums.length <= 105
        1 <= nums[i].length <= 105
        1 <= sum(nums[i].length) <= 105
        1 <= nums[i][j] <= 105
     */
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                new Comparator<int[]>() {
                    @Override
                    public int compare(int[] a, int[] b) {
                        if(a[1]+a[2] < b[1]+b[2]) return -1;
                        if(a[1]+a[2] > b[1]+b[2]) return 1;
                        if(a[1]>b[1]) return -1;
                        return 1;
                    }
                });
        int totalSize=0;
        for(int i=0; i<nums.size(); i++) {
            for(int j=0; j<nums.get(i).size(); j++) {
                totalSize++;
                int[] temp = new int[3];
                temp[0] = nums.get(i).get(j);
                temp[1] = i;
                temp[2] = j;
                pq.add(temp);
            }
        }
        int[] ans = new int[totalSize];
        for(int count=0; count<totalSize; count++) {
            int[] temp = pq.poll();
            ans[count] = temp[0];
        }
        return ans;
    }

    /*
        Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.

        Example 1:


        Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
        Output: [1,2,4,7,5,3,6,8,9]
        Example 2:

        Input: mat = [[1,2],[3,4]]
        Output: [1,2,3,4]


        Constraints:

        m == mat.length
        n == mat[i].length
        1 <= m, n <= 104
        1 <= m * n <= 104
        -105 <= mat[i][j] <= 105
     */

    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] ans = new int[m*n];
        int count = 0;

        for(int i=0; i<m; i++) {
            if(i%2==0) {
                int currR=i;
                int currC=0;

                while(currR>=0 && currC<n) {
                    ans[count++] = mat[currR--][currC++];
                }
            }
            else {
                int currR = 0;
                int currC = i;
                if(currC>=n) {
                    currC = n-1;
                    currR = i-currC;
                }

                while(currR<m && currC>=0) {
                    ans[count++] = mat[currR++][currC--];
                }
            }
        }

        for(int i=1; i<n; i++) {
            if((m-1+i)%2==0) {
                int currR = m-1;
                int currC = i;

                while(currR>=0 && currC<n) {
                    ans[count++] = mat[currR--][currC++];
                }
            }
            else {
                int currR = 0;
                int currC = m-1+i;
                if(currC>=n) {
                    currC = n-1;
                    currR = m-1+i-currC;
                }

                while(currR<m && currC>=0) {
                    ans[count++] = mat[currR++][currC--];
                }
            }
        }
        return ans;
    }
}
