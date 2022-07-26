package stacksqueues;

import java.util.Stack;

public class MinStack2 {
    Stack<Long> stack;
    long minValue;

    public MinStack2() {
        stack = new Stack<>();
    }

    public void push(int vall) {
        long val = vall;
        if(stack.empty()) {
            stack.push(val);
            minValue = val;
            return;
        }

        if(val >= minValue) {
            stack.push(val);
            return;
        }
        stack.push(2*val-minValue);
        minValue = val;
    }

    public void pop() {
        if(stack.peek() > minValue) {
            stack.pop();
            return;
        }
        long val = stack.pop();
        minValue = 2*minValue - val;
    }

    public int top() {
        if(stack.peek() > minValue) {
            long val = stack.peek();
            return (int)val;
        }
        return (int)minValue;
    }

    public int getMin() {
        return (int)minValue;
    }
}
