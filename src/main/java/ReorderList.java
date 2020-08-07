import org.junit.Assert;

public class ReorderList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void reorderList(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        ListNode head2 = reverseList(p1);
        mergeTwoLists(head, head2, true);
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2, boolean flag) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.equals(list2)) return list1;
        if (flag) {
            list1.next = mergeTwoLists(list1.next, list2, false);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next, true);
            return list2;
        }
    }

    private ListNode reverseList(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private String printList(ListNode node) {
        StringBuilder sb = new StringBuilder();
        while(node != null) {
            sb.append(node.val).append(" ");
            node = node.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReorderList rl = new ReorderList();
        ListNode root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        rl.reorderList(root);
        Assert.assertEquals("1 6 2 5 3 4 ", rl.printList(root));

        root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        rl.reorderList(root);
        Assert.assertEquals("1 5 2 4 3 ", rl.printList(root));

    }
}
