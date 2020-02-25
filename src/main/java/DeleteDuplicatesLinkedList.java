public class DeleteDuplicatesLinkedList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;

        while (current != null) {
            if (current.next == null) {
                break;
            }
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public ListNode deleteDuplicatesRecursive(ListNode head) {
        if (head == null) {
            return null;
        }

        // if current node and its next are duplicates, skip them until we find a unique node
        // call recursively on the unique node found.
        if (head.next != null && head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicatesRecursive(head);
        } else {

            // check if the next elements are duplicates recursively
            head.next = deleteDuplicatesRecursive(head.next);
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

    public static void main(String[] args) {
        DeleteDuplicatesLinkedList dd = new DeleteDuplicatesLinkedList();

        ListNode head = getTestData();
        dd.printLinkedList(head);
        head = dd.deleteDuplicates(head);
        dd.printLinkedList(head);

        ListNode head2 = getTestData();
        dd.printLinkedList(head2);
        head2 = dd.deleteDuplicatesRecursive(head2);
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

    static class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

    }
}
