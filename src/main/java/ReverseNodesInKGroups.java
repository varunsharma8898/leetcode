import org.junit.Assert;

public class ReverseNodesInKGroups {

    private ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode begin = dummy;
        ListNode curr = head;
        int i = 0;
        while (curr != null) {
            i++;
            if (i % k == 0) {
                begin = reverse(begin, curr.next);
                curr = begin.next;
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode begin, ListNode end) {
        ListNode prev = begin;
        ListNode curr = begin.next;
        ListNode next = null;
        ListNode last = begin.next; // first element currently, but will become last after reverse operation

        while (curr != end) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        begin.next = prev; // v-imp
        last.next = curr;  // v-imp
        return last;       // v-imp
    }

    public static void main(String[] args) {
        ReverseNodesInKGroups obj = new ReverseNodesInKGroups();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode reversed = obj.reverseKGroup(head, 2);
        Assert.assertEquals("2 1 4 3 5 ", obj.getLinkedListAsString(reversed));
    }

    private String getLinkedListAsString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val + " ");
            head = head.next;
        }
        return sb.toString();
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
