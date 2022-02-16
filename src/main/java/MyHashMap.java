public class MyHashMap {

    Node[] myMap = new Node[10000];

    public MyHashMap() {
    }

    public void put(int key, int value) {
        int index = getIndex(key);
        Node prev = findNode(index, key);
        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.val = value; // key present, update value
        }
    }

    public int get(int key) {
        int index = getIndex(key);
        Node node = findNode(index, key);

        return node.next == null ? -1 : node.next.val;
    }

    private Node findNode(int index, int key) {
        if (myMap[index] == null) {
            myMap[index] = new Node(-1, -1);
            return myMap[index];
        }
        Node prev = myMap[index];
        while (prev.next != null && prev.next.key != key) {
            prev = prev.next;
        }
        return prev;
    }

    public void remove(int key) {
        int index = getIndex(key);
        Node node = findNode(index, key);
        if (node.next != null && node.next.key == key) {
            node.next = node.next.next;
        }
    }

    private int getIndex(int key) {
        return Integer.hashCode(key) % myMap.length;
    }

    class Node {
        int key, val;
        Node next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
        myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
    }

    /**
     * Constraints:
     * 0 <= key, value <= 10^6
     * At most 104 calls will be made to put, get, and remove.
     */

}
