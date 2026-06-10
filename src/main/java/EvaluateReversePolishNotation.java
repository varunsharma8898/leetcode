import java.util.Stack;

import org.junit.Assert;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        int num1, num2;
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    num2 = stack.pop();
                    num1 = stack.pop();
                    stack.push(num1 - num2);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    num2 = stack.pop();
                    num1 = stack.pop();
                    stack.push(num1 / num2);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation obj = new EvaluateReversePolishNotation();
        Assert.assertEquals(9, obj.evalRPN(new String[] { "2", "1", "+", "3", "*" }));
        Assert.assertEquals(6, obj.evalRPN(new String[] { "4", "13", "5", "/", "+" }));
        Assert.assertEquals(22, obj.evalRPN(new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+",
                "5", "+" }));

    }
    /**
     * You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
     *
     * Evaluate the expression. Return an integer that represents the value of the expression.
     *
     * Note that:
     *
     * The valid operators are '+', '-', '*', and '/'.
     * Each operand may be an integer or another expression.
     * The division between two integers always truncates toward zero.
     * There will not be any division by zero.
     * The input represents a valid arithmetic expression in a reverse polish notation.
     * The answer and all the intermediate calculations can be represented in a 32-bit integer.
     * */
}
