import org.junit.Assert;

public class LinkedListCycle2 {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // if (fast.next == null) return null;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        // slow = head;
        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        LinkedListCycle2 obj = new LinkedListCycle2();

        //3 > 2 > 0 > -4
        //    |________|

        ListNode test1 = new ListNode(3);
        test1.next = new ListNode(2);
        test1.next.next = new ListNode(0);
        test1.next.next.next = new ListNode(-4);
        test1.next.next.next.next = test1.next;
        Assert.assertEquals(2, obj.detectCycle(test1).val);
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
