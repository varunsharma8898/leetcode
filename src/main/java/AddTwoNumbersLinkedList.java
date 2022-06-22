import org.junit.Assert;

public class AddTwoNumbersLinkedList {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode sentinell = new ListNode(-1);
        ListNode head = sentinell;
        int sum = 0;
        while (l1 != null || l2 != null) {
            sum /= 10;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            int val = sum % 10;
            head.next = new ListNode(val);
            head = head.next;
        }
        if (sum / 10 == 1) {
            head.next = new ListNode(1);
        }

        return sentinell.next;
    }

    /**
     * Add two numbers stored in linked lists.
     * NOTE: the digits are stored in reverse order.
     *
     * */
    public static void main(String[] args) {
        AddTwoNumbersLinkedList obj = new AddTwoNumbersLinkedList();

        ListNode list1 = getTestData(new int[] { 2, 4, 5 });
        ListNode list2 = getTestData(new int[] { 5, 6, 4 });

        ListNode sum = obj.addTwoNumbers(list1, list2);
        Assert.assertEquals(" 7 0 0 1", obj.getStringRepresentation(sum));
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
