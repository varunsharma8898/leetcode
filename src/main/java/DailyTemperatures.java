import java.util.Stack;

import org.junit.Assert;

public class DailyTemperatures {
    static class Node {
        int val;
        int index;
        Node(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public int[] dailyTemperatures(int[] T) {

        Stack<Node> stack = new Stack<>();
        int[] ret = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            int count = 1;
            while (!stack.isEmpty() && T[i] > stack.peek().val) {
                Node node = stack.pop();
                ret[node.index] = i - node.index;
            }
            stack.push(new Node(T[i], i));
        }
        return ret;
    }

    public static void main(String[] args) {
        DailyTemperatures dt = new DailyTemperatures();
        Assert.assertArrayEquals(new int[] { }, dt.dailyTemperatures(new int[] { }));
        Assert.assertArrayEquals(new int[] { 1, 1, 4, 2, 1, 1, 0, 0 },
                dt.dailyTemperatures(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 }));
    }
}
