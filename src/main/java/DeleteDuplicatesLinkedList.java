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
