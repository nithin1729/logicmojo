package stacksqueues;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for(int i=0; i<s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                if(stack.empty()) return false;
                if(stack.peek() != map.get(s.charAt(i))) return false;
                stack.pop();
            }
            else {
                stack.push(s.charAt(i));
            }
        }
        return stack.empty();
    }
}
