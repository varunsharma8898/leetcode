import java.util.LinkedList;

import org.junit.Assert;

public class RemoveDuplicatesInString {

    public String removeDuplicates(String s, int k) {
        if (k == 1) return "";

        LinkedList<Pair> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek().c != c) {
                stack.push(new Pair(c, 1));
            } else {
                int freq = stack.peek().count;
                if (freq == k - 1) {
                    stack.pop();
                } else {
                    stack.peek().count += 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Pair pair = stack.removeLast();
            for (int i = 0; i < pair.count; i++) {
                sb.append(pair.c);
            }
        }

        return sb.toString();
    }

    static class Pair {
        char c;
        int count;
        Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        RemoveDuplicatesInString obj = new RemoveDuplicatesInString();
        Assert.assertEquals("aa", obj.removeDuplicates("deeedbbcccbdaa", 3));
        Assert.assertEquals("abcd", obj.removeDuplicates("abcd", 2));
        Assert.assertEquals("ps", obj.removeDuplicates("pbbcggttciiippooaais", 2));
    }

}
