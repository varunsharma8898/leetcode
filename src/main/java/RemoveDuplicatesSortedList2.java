public class RemoveDuplicatesSortedList2 {

    /**
     * Given a sorted linked list, delete all nodes that have duplicate numbers,
     * leaving only distinct numbers from the original list.
     * <p>
     * Return the linked list sorted as well.
     */
    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        ListNode iterator = dummy;
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            // find the unique element first
            if (prev.val != curr.val && curr.val != curr.next.val) {
                iterator.next = curr;
                iterator = iterator.next;
            }
            prev = curr;
            curr = curr.next;
        }

        // deal with the last node
        if (prev.val != curr.val) {
            iterator.next = curr;
            iterator = iterator.next;
        }

        iterator.next = null;

        return dummy.next;
    }

    public static void main(String[] args) {
        RemoveDuplicatesSortedList2 dd = new RemoveDuplicatesSortedList2();

        ListNode head = getTestData();
        dd.printLinkedList(head);
        ListNode head2 = dd.deleteDuplicates(head);
        dd.printLinkedList(head2);
    }

    private static ListNode getTestData() {
        ListNode dummy = new ListNode(1);
        ListNode head = dummy;
        for (int i : new int[] { 1, 2, 3, 3, 4, 4, 5 }) {
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
