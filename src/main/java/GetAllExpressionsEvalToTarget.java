import java.util.ArrayList;

/** also see MathExpressionGenerator - same problem **/
public class GetAllExpressionsEvalToTarget {

    // Utility recursive method to generate all possible
    // expressions
    private void getExprUtil(ArrayList<String> res,
                            String curExp, String input,
                            int target, int pos, int curVal,
                            int last) {
        // true if whole input is processed with some
        // operators
        if (pos == input.length()) {
            // if current value is equal to target
            // then only add to final solution
            // if question is : all possible o/p then just
            // push_back without condition
            if (curVal == target) {
                res.add(curExp);
            }
            return;
        }

        // loop to put operator at all positions
        for (int i = pos; i < input.length(); i++) {
            // ignoring case which start with 0 as they
            // are useless for evaluation
            if (i != pos && input.charAt(pos) == '0') {
                break;
            }

            // take part of input from pos to i
            String part = input.substring(pos, i + 1);

            // take numeric value of part
            int cur = Integer.parseInt(part);

            // if pos is 0 then just send numeric value
            // for next recursion
            if (pos == 0) {
                getExprUtil(res, curExp + part, input,
                        target, i + 1, cur, cur);
            }

            // try all given binary operator for evaluation
            else {
                getExprUtil(res, curExp + "+" + part, input,
                        target, i + 1, curVal + cur,
                        cur);
                getExprUtil(res, curExp + "-" + part, input,
                        target, i + 1, curVal - cur,
                        -cur);
                getExprUtil(res, curExp + "*" + part, input,
                        target, i + 1,
                        curVal - last + last * cur,
                        last * cur);
            }
        }
    }

    // Below method returns all possible expression
    // evaluating to target
    private ArrayList<String> getExprs(String input,
                                      int target) {
        ArrayList<String> res = new ArrayList<String>();
        getExprUtil(res, "", input, target, 0, 0, 0);
        return res;
    }

    // method to print result
    static void printResult(ArrayList<String> res, int target) {
        System.out.println("----------");
        System.out.println("Target = " + target);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
        System.out.println();
    }

    // Driver code to test above methods
    public static void main(String[] args) {
        GetAllExpressionsEvalToTarget obj = new GetAllExpressionsEvalToTarget();
        String input = "123";
        int target = 6;
        ArrayList<String> res = obj.getExprs(input, target);
        printResult(res, target);

        input = "125";
        target = 7;
        res = obj.getExprs(input, target);
        printResult(res, target);
    }
}
