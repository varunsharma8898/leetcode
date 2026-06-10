import java.util.ArrayList;
import java.util.List;

/** Also see GetAllExpressionsEvalToTarget - same problem **/
public class MathExpressionGenerator {

    public List<String> generateExpression1(int[] digits, int target) {
        List<String> result = new ArrayList<>();
        generateExpression(digits, target, 0, "", 0, 0, result);
        return result;
    }

    private void generateExpression(int[] digits, int target, int index, String expression, int currentValue, int previousValue, List<String> result) {
        if (index == digits.length) {
            if (currentValue == target) {
                result.add(expression);
            }
            return;
        }

        // Include the current digit with different operators
        for (int i = index; i < digits.length; i++) {
            int currentDigit = digits[i];
            String currentDigitStr = String.valueOf(currentDigit);

            // Add
            // IMP: note we're returning currentDigit as prev
            generateExpression(digits, target, i + 1, expression + "+" + currentDigitStr, currentValue + currentDigit, currentDigit, result);

            // Subtract
            // IMP: note we're retuning -currentDigit as prev
            generateExpression(digits, target, i + 1, expression + "-" + currentDigitStr, currentValue - currentDigit, -currentDigit, result);

            // Multiply
            generateExpression(digits, target, i + 1, expression + "*" + currentDigitStr, currentValue - previousValue + previousValue * currentDigit, previousValue * currentDigit, result);

            // Divide
            if (currentDigit != 0 && currentValue % currentDigit == 0) {
                generateExpression(digits, target, i + 1, expression + "/" + currentDigitStr, currentValue - previousValue + previousValue / currentDigit, previousValue / currentDigit, result);
            }
        }
    }

    public static void main(String[] args) {
        MathExpressionGenerator obj = new MathExpressionGenerator();
        int[] digits = { 2, 3, 4, 10 };
        int target = 20;
        List<String> expressions = obj.generateExpression(digits, target);
        for (String expr : expressions) {
            System.out.println(expr);
        }
    }
    /**
     * +2*3+4+10
     * +2*10
     * -2+3*4+10
     * */

    private List<String> generateExpression(int[] digits, int target) {
        List<String> res = new ArrayList<>();
        helper(digits, target, 0, "", 0, 0, res);
        return res;
    }
    private void helper(int[] digits, int target, int start, String exp, int curr, int prev, List<String> res) {
        if (start == digits.length) {
            if (curr == target) {
                res.add(exp);
            }
            return;
        }
        for (int i = start; i < digits.length; i++) {
            int currVal = digits[i];
            String currValStr = String.valueOf(currVal);
            helper(digits, target, i+1, exp + "+" + currValStr, curr + currVal, currVal, res);
            helper(digits, target, i+1, exp + "-" + currValStr, curr - currVal, -currVal, res);
            helper(digits, target, i+1, exp + "*" + currValStr, curr - prev + prev * currVal, prev * currVal, res);

            if (currVal != 0 && curr % currVal == 0) {
                helper(digits, target, i+1, exp + "/" + currValStr, curr - prev + prev / currVal, prev / currVal, res);
            }
        }
    }


}
