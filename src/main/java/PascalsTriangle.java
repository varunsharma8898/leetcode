import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PascalsTriangle {

    public List<Integer> getRow(int rowIndex) {

//        long[] arr = new long[rowIndex + 1];
//        arr[0] = 1;
//        for (int i = 1; i <= rowIndex; i++) {
//            arr[i] = arr[i-1] * 11;
//        }
//        return toIntArray(arr[rowIndex]);


        switch(rowIndex) {
            case 0:
                return new ArrayList<>(Arrays.asList(1));
            case 1:
                return new ArrayList<>(Arrays.asList(1, 1));
        }

        int[] prev = new int[rowIndex + 1];
        int[] curr = new int[rowIndex + 1];
        prev[0] = 1;
        curr[0] = 1;
        curr[1] = 1;

        for (int i = 2; i <= rowIndex; i++) {
            prev = curr;
            curr = new int[rowIndex + 1];
            curr[0] = 1;
            for (int k = 1; k <= i; k++) {
                if (k == i) {
                    curr[k] = 1;
                }
                curr[k] = prev[k] + prev[k-1];
            }
        }

        return Arrays.stream(curr).boxed().collect(Collectors.toList());
    }


    /**
     *
     * 1
     * 1 1
     * 1 2 1
     * 1 3 3 1
     * 1 4 6 4 1
     * 1 5 10 10 5 1
     *
     * **/

    private List<Integer> toIntArray(long num) {
        List<Integer> res = new ArrayList();
        res = String.valueOf(num).chars().map(Character::getNumericValue).boxed().collect(Collectors.toList());
        return res;
    }

    public static void main(String[] args) {
        PascalsTriangle pt = new PascalsTriangle();
        for (int i  = 0; i < 33; i++) {
            System.out.println(Arrays.toString(pt.getRow(i).toArray()));
        }

//        List<Integer> expected = new ArrayList<>();
//        expected.add(1);
//        Assert.assertTrue(expected.equals(pt.getRow(0)));
//        expected.add(11);
//        Assert.assertTrue(expected.equals(pt.getRow(0)));
//        expected.add(121);
//        Assert.assertTrue(expected.equals(pt.getRow(0)));
//        expected.add(1331);
//        Assert.assertTrue(expected.equals(pt.getRow(0)));
//        expected.add(14641);
//        Assert.assertTrue(expected.equals(pt.getRow(0)));
    }
}
