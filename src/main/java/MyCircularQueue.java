import java.util.Arrays;

import org.junit.Assert;

public class MyCircularQueue {

    private int[] myList;
    private int cursor = 0;
    private int head = 0;
    private int last = 0;

    public MyCircularQueue(int k) {
        myList = new int[k];
        Arrays.fill(myList, -1);
    }

    public boolean enQueue(int value) {

        if (myList[cursor] < 0) {
            myList[cursor] = value;
            last = cursor++;
            if (cursor == myList.length) {
                cursor = 0;
                last = myList.length - 1;
            }
            return true;
        }
        return false;
    }

    public boolean deQueue() {
        if (myList[head] >= 0) {
            myList[head++] = -1;
            if (head == myList.length) {
                head = 0;
            }
            return true;
        }
        return false;
    }

    public int Front() {
        return myList[head];
    }

    public int Rear() {
        return myList[last];
    }

    public boolean isEmpty() {
        return myList[cursor] == -1 && myList[last] == -1;
    }

    public boolean isFull() {
        return myList[cursor] > -1;
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        Assert.assertTrue(myCircularQueue.enQueue(1));
        Assert.assertTrue(myCircularQueue.enQueue(2));
        Assert.assertTrue(myCircularQueue.enQueue(3));
        Assert.assertFalse(myCircularQueue.enQueue(4));
        Assert.assertEquals(3, myCircularQueue.Rear());
        Assert.assertTrue(myCircularQueue.isFull());
        Assert.assertTrue(myCircularQueue.deQueue());
        Assert.assertTrue(myCircularQueue.enQueue(4));
        Assert.assertEquals(4, myCircularQueue.Rear());


        myCircularQueue = new MyCircularQueue(3);
        Assert.assertTrue(myCircularQueue.enQueue(7));
        Assert.assertTrue(myCircularQueue.deQueue());
        Assert.assertEquals(-1, myCircularQueue.Front());
        Assert.assertFalse(myCircularQueue.deQueue());
        Assert.assertEquals(-1, myCircularQueue.Front());
        Assert.assertEquals(-1, myCircularQueue.Rear());
        Assert.assertTrue(myCircularQueue.enQueue(0));
        Assert.assertFalse(myCircularQueue.isFull());
        Assert.assertEquals(0, myCircularQueue.Rear());
        Assert.assertTrue(myCircularQueue.deQueue());
        Assert.assertTrue(myCircularQueue.enQueue(3));
    }
}
