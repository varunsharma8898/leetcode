import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

/**
 * LinkedIn interview question
 */
public class DifferentIterators {

    interface Iter {

        boolean hasNext();

        Integer next();
    }

    static class ListIter implements Iter {

        List<Integer> myList;

        ListIter(List<Integer> list) {
            myList = new ArrayList<>(list);
        }

        @Override
        public boolean hasNext() {
            return myList.size() > 0;
        }

        @Override
        public Integer next() {
            return myList.remove(0);
        }
    }

    static class QueueListIter implements Iter {

        PriorityQueue<ListIter> queue;

        Integer lastReturnedValue = null;

        QueueListIter(List<ListIter> listIters) {
            queue = new PriorityQueue<>(Comparator.comparingInt(iter -> iter.myList.get(0)));
            for (ListIter listIter : listIters) {
                if (listIter.hasNext()) {
                    queue.add(listIter);
                }
            }
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in the queue");
            }
            while (!queue.isEmpty()) { // needed because we dont want to send duplicate entries
                ListIter iter = queue.poll();
                Integer nextValue = iter.next();
                if (iter.hasNext()) {
                    queue.add(iter);
                }
                if (!nextValue.equals(lastReturnedValue)) {
                    lastReturnedValue = nextValue;
                    return nextValue;
                }
            }
            throw new NoSuchElementException("No more elements in the queue");
        }
    }

    public static void main(String[] args) {
        ListIter listIter = new DifferentIterators.ListIter(List.of(1, 2, 3));
        while (listIter.hasNext()) {
            System.out.print(listIter.next() + " ");
        }
        System.out.println("\n--------");
        Iter iter = new QueueListIter(
                List.of(
                        new DifferentIterators.ListIter(List.of(1, 2, 3, 4, 5, 6)),
                        new DifferentIterators.ListIter(List.of(3, 5, 7)),
                        new DifferentIterators.ListIter(List.of(2, 4, 6, 8)),
                        new DifferentIterators.ListIter(List.of(4, 5, 6, 9)),
                        new DifferentIterators.ListIter(List.of(8, 9, 10))
                )
        );

        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }

    }
}
