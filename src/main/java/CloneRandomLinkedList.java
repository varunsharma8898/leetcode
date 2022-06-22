import java.util.Random;

public class CloneRandomLinkedList {

    public RandomListNode copyRandomList(RandomListNode head) {

        // first create a copy of each node and attach right next to the original

        RandomListNode node = head;
        while (node != null) {
            RandomListNode clone = new RandomListNode(node.val);
            clone.next = node.next;
            node.next = clone;
            node = node.next;
        }

        // then assign random pointers to clone nodes
        RandomListNode iter = head;
        while (iter != null) {
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }

        // extract out the clone list and fix original list
        iter = head;
        RandomListNode dummyHead = new RandomListNode(0);
        RandomListNode copyHead = dummyHead;
        while (iter != null) {
            RandomListNode next = iter.next.next;

            // Extract clone list
            RandomListNode copy = iter.next;
            copyHead.next = copy;
            copyHead = copyHead.next;

            // Fix original
            iter.next = next;

            iter = next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(0);
        RandomListNode iter = head;
        for (Integer[] list : new Integer[][] {
                { 7, null },
                { 13, 0 },
                { 11, 4 },
                { 10, 2 },
                { 1, 0 }
        }) {

        }
    }

    static class RandomListNode {
        int val;
        RandomListNode next;
        RandomListNode random;
        public RandomListNode(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
