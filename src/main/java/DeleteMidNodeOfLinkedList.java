import org.junit.Assert;

public class DeleteMidNodeOfLinkedList {

    public ListNode deleteMiddle(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        DeleteMidNodeOfLinkedList dd = new DeleteMidNodeOfLinkedList();

        ListNode head = getTestData();
        dd.printLinkedList(head);
        head = dd.deleteMiddle(head);
        dd.printLinkedList(head);
    }

    private void printLinkedList(ListNode node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(" " + node.val);
            node = node.next;
        }
        System.out.println(sb.toString());
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
