public class PartitionList {

    /**
     * Given a linked list and a value x, partition it such that all nodes less than x
     * come before nodes greater than or equal to x.
     * <p>
     * You should preserve the original relative order of the nodes in each of the two partitions.
     * <p>
     * Example:
     * <p>
     * Input: head = 1->4->3->2->5->2, x = 3
     * Output: 1->2->2->4->3->5
     */

    public ListNode partition(ListNode head, int x) {

        if (head == null) {
            return null;
        }

        ListNode before = new ListNode(0);
        ListNode after = new ListNode(0);
        ListNode dummyBefore = before;
        ListNode dummyAfter = after;

        while (head != null) {
            if (head.val >= x) {
                after.next = head;
                after = after.next;
            } else {
                before.next = head;
                before = before.next;
            }
            head = head.next;
        }

        before.next = dummyAfter.next;
        after.next = null;

        return dummyBefore.next;
    }

    public static void main(String[] args) {

        PartitionList pl = new PartitionList();
        ListNode node = getTestData();

        pl.printLinkedList(node);
        node = pl.partition(node, 3);
        pl.printLinkedList(node);

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
