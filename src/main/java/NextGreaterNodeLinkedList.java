import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterNodeLinkedList {

    public int[] nextLargerNodes(ListNode head) {

        List<Integer> arr = new ArrayList<>();
        for (ListNode node = head; node != null; node = node.next) {
            arr.add(node.val);
        }

        Stack<Integer> stack = new Stack<>();
        int[] res = new int[arr.size()];

        for (int i = 0; i < arr.size(); i++) {
            while (!stack.isEmpty() && arr.get(stack.peek()) < arr.get(i)) {
                res[stack.pop()] = arr.get(i);
            }

            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {

        NextGreaterNodeLinkedList ngn = new NextGreaterNodeLinkedList();
        ListNode node = getTestData();

        ngn.printLinkedList(node);
        int[] test = ngn.nextLargerNodes(node);
//        ngn.printLinkedList(node);
        System.out.println();
        for (int i : test) {
            System.out.print(i + " ");
        }
    }

    private static ListNode getTestData() {
        ListNode dummy = new ListNode(1);
        ListNode head = dummy;
        for (int i : new int[] { 4, 3, 2, 5, 2 }) {
            dummy.next = new ListNode(i);
            dummy = dummy.next;
        }
        return head;
    }

    private void printLinkedList(ListNode node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(" " + node.val);
            node = node.next;
        }
        System.out.println(sb.toString());
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
