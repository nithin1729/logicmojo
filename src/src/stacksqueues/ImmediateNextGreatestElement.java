package stacksqueues;

import java.util.Stack;

public class ImmediateNextGreatestElement {
    static void printNGE(int arr[], int n)
    {
        //Write Your Code here
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<arr.length; i++) {
            while(!stack.empty() && arr[stack.peek()] < arr[i]) {
                ans[stack.peek()] = arr[i];
                stack.pop();
            }
            stack.push(i);
        }
        while(!stack.empty()) {
            ans[stack.peek()] = -1;
            stack.pop();
        }
        for(int i=0; i<ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    public static void main(String args[])
    {
        int arr[]= {1,3,2,4};
        int n = arr.length;
        printNGE(arr, n);
    }
}
