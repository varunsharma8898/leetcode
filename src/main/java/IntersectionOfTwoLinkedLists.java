import org.junit.Assert;

public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode aPointer = headA;
        ListNode bPointer = headB;
        ListNode intersection = null;

        while (aPointer != bPointer) {
            aPointer = aPointer == null ? headB : aPointer.getNext();
            bPointer = bPointer == null ? headA : bPointer.getNext();
        }

        if (aPointer == bPointer) {
            intersection = aPointer;
        }
        return intersection;
    }

    public static void main(String[] args) {
        IntersectionOfTwoLinkedLists testObj = new IntersectionOfTwoLinkedLists();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

        node5.setNext(node6);
        node6.setNext(node7);
        node7.setNext(node8);
        node8.setNext(node2);

        //                1 ->
        //                    |-> 2 -> 3 -> 4
        // 5 -> 6 -> 7 -> 8 ->

        ListNode intersection = testObj.getIntersectionNode(node1, node5);
        Assert.assertEquals(intersection, node2);
    }

    static class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}
