import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

public class LRUCache {

    private int capacity;

    private Node head;

    private Node tail;

    private Map<Integer, Node> cacheMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cacheMap = new HashMap<>(capacity);
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);
            moveToFront(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);
            node.val = value;
            cacheMap.put(key, node);
            moveToFront(node);
        } else {
            if (cacheMap.size() == capacity) {
                Node last = removeFromTail();
                cacheMap.remove(last.key);
            }
            Node node = new Node(key, value);
            cacheMap.put(key, node);
            moveToFront(node);
        }
    }

    private Node removeFromTail() {
        Node last = tail.prev;
        last.prev.next = tail;
        tail.prev = last.prev;
        return last;
    }

    private void moveToFront(Node node) {
        // remove node from its place first
        Node next = node.next;
        Node prev = node.prev;

        if (prev != null) {
            prev.next = next;
        }
        if (next != null) {
            next.prev = node.prev;
        }

        // now attach it to the front
        Node tmp = head.next;
        head.next = node;
        node.next = tmp;
        node.prev = head;
        tmp.prev = node;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        Assert.assertEquals(1, cache.get(1));
        Assert.assertEquals(2, cache.get(2));
        cache.put(4, 4);
        Assert.assertEquals(-1, cache.get(3)); // not found, was evicted in the last put
        Assert.assertEquals(4, cache.get(4));
    }

    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
