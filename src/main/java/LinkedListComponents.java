import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;

public class LinkedListComponents {

    public int numComponents(ListNode head, int[] G) {
        Set<Integer> intSet = new HashSet<>();
        for (int i : G) {
            intSet.add(i);
        }
        int count = 0;
        while (head != null) {
            if (intSet.contains(head.val) && (head.next == null || !intSet.contains(head.next.val))) {
                count++;
            }
            head = head.next;
        }
        return count;
    }

    public int numComponentsRecursive(ListNode head, int[] G) {
        Set<Integer> intSet = new HashSet<>();
        for (int i : G) {
            intSet.add(i);
        }

        int count = 0;
        return calculateComponentsRecursive(head, intSet, count);
    }

    private int calculateComponentsRecursive(ListNode head, Set<Integer> intSet, int count) {

        if (head == null) {
            return count;
        }

        if (intSet.contains(head.val)) {
            while (head.next != null && intSet.contains(head.val) && intSet.contains(head.next.val)) {
                head = head.next;
            }
            return calculateComponentsRecursive(head.next, intSet, ++count);
        } else {
            count = calculateComponentsRecursive(head.next, intSet, count);
        }

        return count;
    }

    public static void main(String[] args) {
        LinkedListComponents dd = new LinkedListComponents();

        ListNode head = getTestData();
        int num = dd.numComponents(head, new int[] { 0, 1, 3 });
        Assert.assertEquals(2, num);

        ListNode head2 = getTestData();
        int num2 = dd.numComponentsRecursive(head2, new int[] { 0, 1, 3 });
        Assert.assertEquals(2, num2);
    }

    private static ListNode getTestData() {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        for (int i : new int[] { 1, 2, 3 }) {
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
