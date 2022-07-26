package stacksqueues;

import java.util.Stack;

public class LargestAreaBinaryMatrix {
    private int calculateArea(int[] arr) {
        if(arr.length==0) return 0;

        Stack<Integer> stack = new Stack<>();

        int[] prevSmaller = new int[arr.length];
        int[] nextSmaller = new int[arr.length];

        for(int i=0; i<arr.length; i++) {
            while(!stack.empty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if(stack.empty()) prevSmaller[i] = -1;
            else prevSmaller[i] = stack.peek();

            stack.push(i);
        }

        stack.clear();

        for(int i=arr.length-1; i>=0; i--) {
            while(!stack.empty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if(stack.empty()) nextSmaller[i] = arr.length;
            else nextSmaller[i] = stack.peek();

            stack.push(i);
        }

        int ans = 0;
        for(int i=0; i<arr.length; i++) ans = Math.max(ans, (nextSmaller[i]-prevSmaller[i]-1)*arr[i]);
        return ans;
    }

    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int[][] arr = new int[matrix.length][matrix[0].length];
        for(int j=0; j<matrix[0].length; j++) arr[0][j] = (matrix[0][j] - '0');
        int ans = calculateArea(arr[0]);

        for(int i=1; i<arr.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                if(matrix[i][j] == '1') arr[i][j] = 1 + arr[i-1][j];
                else arr[i][j] = 0;
            }
            ans = Math.max(ans, calculateArea(arr[i]));
        }
        return ans;
    }
}
