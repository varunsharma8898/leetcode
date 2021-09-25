import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

public class SwapNodesInLinkedList {

    public ListNode swapNodesAlternate(ListNode head, int k) {
        List<Integer> myList = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            myList.add(node.val);
            node = node.next;
        }

        int a = myList.get(k - 1);
        int b = myList.get(myList.size() - k);
        myList.set(k - 1, b);
        myList.set(myList.size() - k, a);

        node = head;
        for (int i : myList) {
            node.val = i;
            node = node.next;
        }
        return head;
    }

    public ListNode swapNodes(ListNode head, int k) {

        ListNode slowPointer = head, fastPointer = head;
        ListNode start, end;

        for (int i = 0; i < k - 1; i++) {
            fastPointer = fastPointer.next;
        }
        start = fastPointer;

        while (fastPointer.next != null) {
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }
        end = slowPointer;

        int tmp = start.val;
        start.val = end.val;
        end.val = tmp;

        return head;
    }

    public static void main(String[] args) {

        SwapNodesInLinkedList obj = new SwapNodesInLinkedList();

        //7 9 6 6 7 8 3 0 9 5
        ListNode node1 = new ListNode(7, new ListNode(9, new ListNode(6, new ListNode(6, new ListNode(7, new ListNode(8,
                new ListNode(3, new ListNode(0, new ListNode(9, new ListNode(5))))))))));
        Assert.assertEquals("7 9 6 6 7 8 3 0 9 5 ", printPretty(node1));

        node1 = obj.swapNodes(node1, 5);
        Assert.assertEquals("7 9 6 6 8 7 3 0 9 5 ", printPretty(node1));

        //7 9 6 6 7 8 3 0 9 5 1
        ListNode node2 = new ListNode(7, new ListNode(9, new ListNode(6, new ListNode(6, new ListNode(7, new ListNode(8,
                new ListNode(3, new ListNode(0, new ListNode(9, new ListNode(5, new ListNode(1)))))))))));
        Assert.assertEquals("7 9 6 6 7 8 3 0 9 5 1 ", printPretty(node2));

        node2 = obj.swapNodes(node2, 5);
        Assert.assertEquals("7 9 6 6 3 8 7 0 9 5 1 ", printPretty(node2));

        ListNode node3 = new ListNode(1);
        node3 = obj.swapNodes(node3, 1);
        Assert.assertEquals("1 ", printPretty(node3));

        ListNode node4 = new ListNode(1, new ListNode(2));
        node4 = obj.swapNodes(node4, 1);
        Assert.assertEquals("2 1 ", printPretty(node4));
    }

    private static String printPretty(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val + " ");
            head = head.next;
        }
        return sb.toString();
    }

    public static class ListNode {

        int val;

        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
