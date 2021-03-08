// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

import java.util.Iterator;
import java.util.NoSuchElementException;

class PeekingIterator implements Iterator<Integer> {
    Integer next = null;
    Iterator<Integer> iter;
    boolean done;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iter = iterator;
        if (iter.hasNext())
            next = iter.next();
        else
            done = true;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int tmp = next; // copy next into tmp which we actually want to return and next will be updated

        if (done)
            // Ask interviewer what he wants to return in case of no next element
            // throw new NoSuchElementException();
            return tmp;

        if (iter.hasNext())
            next = iter.next();
        else
            done = true;
        return tmp;
    }

    @Override
    public boolean hasNext() {
        return !done;
    }
}