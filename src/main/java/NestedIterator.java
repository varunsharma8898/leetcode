import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {

    List<Integer> myList;

    int cursor = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        myList = new ArrayList<>();
        helper(nestedList);
    }

    private void helper(List<NestedInteger> nestedList) {
        for (NestedInteger nestedInt : nestedList) {
            if (nestedInt.isInteger()) {
                myList.add(nestedInt.getInteger());
            } else {
                helper(nestedInt.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return myList.get(cursor++);
    }

    @Override
    public boolean hasNext() {
        return cursor < myList.size();
    }
}
