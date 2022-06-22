import org.junit.Assert;

public class ReverseLinkedList2 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        int count = 1;
        ListNode prev = null;
        ListNode node = head;
        while (count < left) {
            count++;
            prev = node;
            node = node.next;
        }


        ListNode curr = node;
        ListNode next = null;

        while (count < right) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        prev.next = curr.next;
        return head;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private void printLinkedList(ListNode head) {
        System.out.println();
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    private boolean compareLinkedLists(ListNode head1, ListNode head2) {
        while (head1 != null && head2 != null) {
            if (head1.val != head2.val) return false;
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReverseLinkedList2 rll = new ReverseLinkedList2();
        rll.printLinkedList(rll.reverseBetween(head, 2, 4));
//        Assert.assertTrue(rll.compareLinkedLists(head, rll.reverseList(head)));
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
