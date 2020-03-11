public class NextGreaterNodeLinkedList {

    public int[] nextLargerNodes(ListNode head) {

        return new int[] { };
    }

    public static void main(String[] args) {

        NextGreaterNodeLinkedList ngn = new NextGreaterNodeLinkedList();
        ListNode node = getTestData();

        ngn.printLinkedList(node);
        int[] test = ngn.nextLargerNodes(node);
        ngn.printLinkedList(node);
    }

    private static ListNode getTestData() {
        ListNode dummy = new ListNode(1);
        ListNode head = dummy;
        for (int i : new int[] { 4, 3, 2, 5, 2 }) {
            dummy.next = new ListNode(i);
            dummy = dummy.next;
        }
        return head;
    }

    private void printLinkedList(ListNode node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(" " + node.val);
            node = node.next;
        }
        System.out.println(sb.toString());
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
