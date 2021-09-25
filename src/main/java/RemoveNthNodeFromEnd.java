import org.junit.Assert;

public class RemoveNthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0); // important to create a dummy node to handle cases where list has only 1 node and that too has to be removed
        ListNode slow = start;                // keeps track of prev-node of slow-pointer
        ListNode fast = start;                // fast-pointer = slow-pointer + n
        start.next = head;
        for (int i = 1; i <= n + 1; i++) {    // n + 1
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return start.next;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEnd obj = new RemoveNthNodeFromEnd();
        ListNode node1 = getTestData();
        Assert.assertEquals(" 0 1 2 3 4 5", printLinkedList(node1));
        node1 = obj.removeNthFromEnd(node1, 2);
        Assert.assertEquals(" 0 1 2 3 5", printLinkedList(node1));


        ListNode node2 = new ListNode(1);
        Assert.assertEquals(" 1", printLinkedList(node2));
        node2 = obj.removeNthFromEnd(node2, 1);
        Assert.assertEquals("", printLinkedList(node2));
    }


    private static ListNode getTestData() {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        for (int i : new int[] { 1, 2, 3, 4, 5 }) {
            dummy.next = new ListNode(i);
            dummy = dummy.next;
        }
        return head;
    }

    private static String printLinkedList(ListNode node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(" " + node.val);
            node = node.next;
        }
        return sb.toString();
//        System.out.println(sb.toString());
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
