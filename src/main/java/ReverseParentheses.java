import java.util.Stack;

import org.junit.Assert;

public class ReverseParentheses {

    public static void main(String[] args) {
        ReverseParentheses obj = new ReverseParentheses();
        Assert.assertEquals("my name is varun", obj.reverseStringInBrackets("my(eman)is(nurav)"));

        Assert.assertEquals("samsclub", obj.reverseStringsInNestedBrackets("(bu(ms(lc))as)"));
        Assert.assertEquals("salcmsub", obj.reverseStringsInNestedBrackets("(bu(ms)(lc)as)"));
    }

    private String reverseStringsInNestedBrackets(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == ')') {

                StringBuilder builder = new StringBuilder();
                while (stack.peek() != '(') {
                    builder.append(stack.pop());
                }
                stack.pop(); // pop (

                for (char ch : builder.toString().toCharArray()) {
                    stack.push(ch);
                }
            } else {
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();

    }

    private String reverseStringInBrackets(String s) {

        if (s == null || s.isEmpty()) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) == '(') {
                left++;
                sb.append(" ");
                while (s.charAt(left) != ')') {
                    stack.push(s.charAt(left));
                    left++;
                }
                left++;
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(" ");
            } else {
                sb.append(s.charAt(left));
                left++;
            }
        }

        String result = sb.toString();
        if (result.endsWith(" ")) {
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }
}

