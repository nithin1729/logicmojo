package stacksqueues;

import java.util.Stack;

public class HistogramArea {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] prevSmaller = new int[heights.length];
        int[] nextSmaller = new int[heights.length];

        for(int i=0; i<heights.length; i++) {
            while(!stack.empty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }

            if(stack.empty()) {
                prevSmaller[i] = -1;
            }
            else {
                prevSmaller[i] = stack.peek();
            }

            stack.push(i);
        }

        stack.clear();

        for(int i=heights.length-1; i>=0; i--) {
            while(!stack.empty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }

            if(stack.empty()) {
                nextSmaller[i] = heights.length;
            }
            else {
                nextSmaller[i] = stack.peek();
            }

            stack.push(i);
        }

        int ans = 0;
        for(int i=0; i<heights.length; i++) {
            ans = Math.max(ans, heights[i]*(nextSmaller[i] - prevSmaller[i] - 1));
        }
        return ans;
    }
}
