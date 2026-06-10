import java.util.Stack;

import org.junit.Assert;

public class ValidParentheses {

    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        Assert.assertTrue(vp.isValid("()"));
        Assert.assertTrue(vp.isValid("()[]{}"));
        Assert.assertFalse(vp.isValid("(]"));
    }

}
