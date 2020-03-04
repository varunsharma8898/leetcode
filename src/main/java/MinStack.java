import java.util.LinkedList;

import org.junit.Assert;

public class MinStack {

    LinkedList<int[]> myList;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        myList = new LinkedList<>();
    }

    public void push(int x) {
        if (myList.isEmpty()) {
            myList.addLast(new int[] { x, x });
        } else {
            int min = Math.min(getMin(), x);
            myList.addLast(new int[] { x, min });
        }
    }

    public void pop() {
        myList.removeLast();
    }

    public int top() {
        int[] test = myList.getLast();
        return test[0];
    }

    public int getMin() {
        int[] test = myList.getLast();
        return test[1];
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        String[] commands = new String[] { "push", "push", "push", "top", "pop", "getMin", "pop", "getMin", "pop",
                "push", "top", "getMin", "push", "top", "getMin", "pop", "getMin" };
        Integer[] vals = new Integer[] { 2147483646, 2147483646, 2147483647, null, null, null, null, null, null,
                2147483647, null, null, -2147483648, null, null, null, null };
        Integer[] output = new Integer[vals.length];
        Integer[] expected = new Integer[] { null, null, null, 2147483647, null, 2147483646, null, 2147483646, null,
                null, 2147483647, 2147483647, null, -2147483648, -2147483648, null, 2147483647 };

        for (int i = 0; i < commands.length; i++) {
            Integer outputVal = null;
            switch (commands[i]) {
                case "push":
                    minStack.push(vals[i]);
                    break;
                case "pop":
                    minStack.pop();
                    break;
                case "top":
                    outputVal = minStack.top();
                    break;
                case "getMin":
                    outputVal = minStack.getMin();
                    break;
            }
            output[i] = outputVal;
        }

        Assert.assertArrayEquals(expected, output);
    }
}
