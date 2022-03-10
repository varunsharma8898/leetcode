public class ReverseOddEvenLinkedList {

    private ListNode process(ListNode head) {
        // first split the input in two equal length linked lists
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode first = head;
        ListNode second = slow.next;
        ListNode mid = slow.next;
        slow.next = null;

        // Now reverse the second list
        second = reverse(second);

        // Swap every odd element of both lists
        int i = 0;
        while (second.next != null) {
            if (i % 2 == 0) {
                int tmp = first.val;
                first.val = second.val;
                second.val = tmp;
            }
            i++;
            first = first.next;
            second = second.next;
        }

        first.next = reverse(mid);
        return head;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
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

    private void printLinkedList(ListNode head) {
        System.out.println();
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ReverseOddEvenLinkedList obj = new ReverseOddEvenLinkedList();

        System.out.println("Input = ");
        obj.printLinkedList(head);
        System.out.println();
        System.out.println();
        System.out.println("Expected = 6 2 4 3 5 1");
        obj.process(head);

        System.out.println();
        System.out.println("Output = ");
        obj.printLinkedList(head);
    }

    /**
     * Given a Single Linked list of length N ( N is always even).
     *
     * Perform the following operation:
     *
     *     Reverse the linked list
     *     Delete the nodes at the end and carry the operation again.
     *
     * Note : No extra memory and number of nodes is 10^5
     *
     * ex:
     * i/p
     * 1->2->3->4->5->6
     *
     * o/p
     * 6->2->4->3->5->1
     *
     * Explanation:
     *
     * 1 2 3 4 5 6 -> 6 5 4 3 2 1 -> 6 2 3 4 5 1 -> 6 2 4 3 5 1
     *
     * first we reverse the list we get 6 5 4 3 2 1. we then delete the node 6 and 1 so our linkedList looks something 5 4 3 2
     *
     * we reverse it 2 3 4 5. delete end 3 4
     *
     * reverse it 4 3 and delete the ends.
     *
     * so effectively list is 6 2 4 3 5 1.
     *
     * */
}
