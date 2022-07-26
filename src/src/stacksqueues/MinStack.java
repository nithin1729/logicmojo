package stacksqueues;

import java.util.Stack;

public class MinStack {
    class StackObj {
        int val;
        int minValue;

        StackObj(int val, int minValue) {
            this.val = val;
            this.minValue = minValue;
        }
    }

    Stack<StackObj> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        int minValue;
        if(stack.empty()) {
            minValue = val;
        }
        else {
            minValue = Math.min(val, stack.peek().minValue);
        }
        stack.push(new StackObj(val, minValue));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().minValue;
    }
}
