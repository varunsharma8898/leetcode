import java.util.Stack;

import org.junit.Assert;

public class BaseballGame {

    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        Integer sum = 0;
        for (String s : ops) {
            switch (s) {
                case "D":
                    int doubleVal = 2 * stack.peek();
                    stack.push(doubleVal);
                    sum += doubleVal;
                    break;
                case "C":
                    Integer cancelled = stack.pop();
                    sum -= cancelled;
                    break;
                case "+":
                    Integer lastVal = stack.pop();
                    int newVal = stack.peek() + lastVal;
                    sum += newVal;
                    stack.push(lastVal);
                    stack.push(newVal);
                    break;
                default:
                    Integer num = Integer.valueOf(s);
                    stack.push(num);
                    sum += num;
                    break;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        BaseballGame game = new BaseballGame();

        String[] input1 = { "5", "2", "C", "D", "+" };
        Assert.assertEquals(30, game.calPoints(input1));

        String[] input2 = { "5", "-2", "4", "C", "D", "9", "+", "+" };
        Assert.assertEquals(27, game.calPoints(input2));
    }

/*
*
*
Given a list of strings, each string can be one of the 4 following types:

Integer (one round's score): Directly represents the number of points you get in this round.
"+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
"D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
"C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.

Each round's operation is permanent and could have an impact on the round before and the round after.

You need to return the sum of the points you could get in all the rounds.

Example 1:

Input: ["5","2","C","D","+"]
Output: 30
Explanation:
Round 1: You could get 5 points. The sum is: 5.
Round 2: You could get 2 points. The sum is: 7.
Operation 1: The round 2's data was invalid. The sum is: 5.
Round 3: You could get 10 points (the round 2's data has been removed). The sum is: 15.
Round 4: You could get 5 + 10 = 15 points. The sum is: 30.

* */
}
