import java.util.Stack;

import org.junit.Assert;

public class AddTwoNumbersLinkedList2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // either use stack or reverse the linked lists
        // rest of the logic will remain the same as add-two-numbers-1
        // the result list can be made as a simple list and then reversed before returning,
        // or we can add a new node at the front itself instead of reversing.

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        ListNode sentinell = new ListNode(-1);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            sum /= 10;
            if (!s1.isEmpty()) {
                sum += s1.pop();
            }
            if (!s2.isEmpty()) {
                sum += s2.pop();
            }
            int val = sum % 10;
            addToFront(val, sentinell);
        }
        if (sum / 10 == 1) {
            addToFront(1, sentinell);
        }

        return sentinell.next;
    }

    private void addToFront(int val, ListNode sentinell) {
        ListNode curr = new ListNode(val);
        ListNode next = sentinell.next;

        sentinell.next = curr;
        curr.next = next;
    }
    /**
     * Add two numbers stored in linked lists.
     * NOTE: the digits are stored in order.
     *
     * ex. 123 + 456 = 579
     * 10 + 100 = 110
     *
     * */
    public static void main(String[] args) {
        AddTwoNumbersLinkedList2 obj = new AddTwoNumbersLinkedList2();

        ListNode list1 = getTestData(new int[] { 2, 4, 5 });
        ListNode list2 = getTestData(new int[] { 5, 6, 4 });

        ListNode sum = obj.addTwoNumbers(list1, list2);
        Assert.assertEquals(" 8 0 9", obj.getStringRepresentation(sum));

        ListNode sum2 = obj.addTwoNumbers(getTestData(new int[] {7,2,4,3}), getTestData(new int[] {5,6,4}));
        Assert.assertEquals(" 7 8 0 7", obj.getStringRepresentation(sum2));
    }

    private static ListNode getTestData(int[] arr) {
        ListNode sentinell = new ListNode(1);
        ListNode node = sentinell;
        for (int i : arr) {
            node.next = new ListNode(i);
            node = node.next;
        }
        return sentinell.next;
    }

    private String getStringRepresentation(ListNode node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(" " + node.val);
            node = node.next;
        }
        return sb.toString();
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
