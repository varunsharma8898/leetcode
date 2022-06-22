import org.junit.Assert;

public class MergeSortedLinkedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        ListNode head = new ListNode(-1);
        ListNode curr = head;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                ListNode next = list2.next;
                curr.next = list2;
                list2 = next;
            } else {
                ListNode next = list1.next;
                curr.next = list1;
                list1 = next;
            }
            curr = curr.next;
        }

        if (list1 == null) {
            curr.next = list2;
        } else if (list2 == null) {
            curr.next = list1;
        }
        return head.next;
    }

    public static void main(String[] args) {
        MergeSortedLinkedLists obj = new MergeSortedLinkedLists();
        ListNode list1 = obj.getTestData(new int[] { 1, 2, 4 });
        ListNode list2 = obj.getTestData(new int[] { 1, 3, 4 });

        Assert.assertEquals(" 1 1 2 3 4 4", obj.getLinkedListAsString(obj.mergeTwoLists(list1, list2)));
    }

    private ListNode getTestData(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        for (int i : arr) {
            dummy.next = new ListNode(i);
            dummy = dummy.next;
        }
        return head.next;
    }

    private String getLinkedListAsString(ListNode node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(" " + node.val);
            node = node.next;
        }
        return sb.toString();
    }

    public class ListNode {
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
