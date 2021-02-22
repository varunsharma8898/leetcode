import org.junit.Assert;

public class LinkedListCycle {

    static class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Floyd's Tortoise and Hare algorithm
    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (slowPointer.next != null && fastPointer.next != null && fastPointer.next.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (slowPointer.equals(fastPointer) && slowPointer.val == fastPointer.val) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        LinkedListCycle obj = new LinkedListCycle();

        //3,2,0,-4
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        Assert.assertTrue(obj.hasCycle(node1));

        ListNode node5 = new ListNode(1);
        ListNode node6 = new ListNode(2);
        node5.next = node6;
        node6.next = node5;
        Assert.assertTrue(obj.hasCycle(node5));

        ListNode node7 = new ListNode(1);
        Assert.assertFalse(obj.hasCycle(node7));

        Assert.assertFalse(obj.hasCycle(null));
    }
}
