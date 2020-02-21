import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

import org.junit.Assert;

public class ArrayOfDoubledPairs {

    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> actual = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            actual.put(arr[i], actual.getOrDefault(arr[i], 0) + 1);
        }

        for (int num : actual.keySet()) {
            if (actual.get(num) == 0) {
                continue;
            }
            int want = num < 0 ? num / 2 : num * 2;
            if (num < 0 && num % 2 != 0 || actual.get(num) > actual.getOrDefault(want, 0)) {
                return false;
            }
            actual.put(want, actual.get(want) - actual.get(num));
        }

        return true;
    }

    public boolean canReorderDoubledUsingPriorityQueue(int[] arr) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((Comparator.comparingInt(Math::abs)));
//        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> Math.abs(o1) - Math.abs(o2)));

        for (int i : arr) {
            pq.offer(i);
        }

        while (!pq.isEmpty()) {
            int num = pq.poll();
            if (!pq.remove(num * 2)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayOfDoubledPairs adp = new ArrayOfDoubledPairs();
        List<TestCase> testCases = getTestCases();
        for (TestCase testCase : testCases) {
            Assert.assertEquals(testCase.expected, adp.canReorderDoubled(testCase.input));
            Assert.assertEquals(testCase.expected, adp.canReorderDoubledUsingPriorityQueue(testCase.input));
        }
    }

    private static List<TestCase> getTestCases() {
        List<TestCase> testCases = new ArrayList<>();
        testCases.add(new TestCase(false, new int[] { 2, 1, 2, 6 }));
        testCases.add(new TestCase(false, new int[] { 3, 1, 3, 6 }));
        testCases.add(new TestCase(false, new int[] { 1, 2, 4, 16, 8, 4 }));
        testCases.add(new TestCase(true, new int[] { -3, -6, -6, -12, -24, -3, -96, -48 }));
        testCases.add(new TestCase(true, new int[] { 4, -2, 2, -4 }));
        testCases.add(new TestCase(true, new int[] { 7, -15, -15, 23, -3, 80, -35, 40,
                68, 22, 44, 98, 20, 0, -34, 8, 40, 41, 16, 46, 16, 49, -6, -11, 35, -15, -74, 72, -8, 60, 40, -2, 0, -6,
                34, 14, -16, -92, 54, 14, -68, 82, -30, 50, 22, 25, 16, 70, -1, -96, 11, 45, 54, 40, 92, -35, 29, 80,
                46, -30, 27, 7, -70, -37, 41, -46, -98, 1, -33, -24, -86, -70, 80, -43, 98, -49, 30, 0, 27, 2, 82, 36,
                0, -48, 3, -100, 58, 32, 90, -22, -50, -12, 36, 6, -3, -66, 72, 8, 49, -30 }));
        return testCases;
    }

    static class TestCase {
        boolean expected;
        int[] input;
        TestCase(boolean exp, int[] in) {
            this.expected = exp;
            this.input = in;
        }
    }
}
