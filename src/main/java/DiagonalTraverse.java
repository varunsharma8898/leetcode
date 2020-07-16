import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

public class DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] res = new int[rows * cols];
        int index = 0;
        Map<Integer, List<Integer>> resMap = new HashMap<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int sum = i + j;
                if (!resMap.containsKey(sum)) {
                    resMap.put(sum, new ArrayList<>());
                }
                resMap.get(sum).add(matrix[i][j]);
            }
        }
        for (Map.Entry entry : resMap.entrySet()) {
            List<Integer> list = (List<Integer>) entry.getValue();
            if ((int) entry.getKey() % 2 == 0) {
                Collections.reverse(list);
            }
            for (int val : list) {
                res[index++] = val;
            }
        }
        return res;
    }

    /**
     * The key here is to understand that sum of i and j will always lead to diagonals.
     * for ex. 1,0 and 0,1 will always be diagonal 1; 2,0, 1,1 and 0,2 == 2;
     * And for diagonals with sum == 2, just reverse the array to get data in opposite direction.
     */

    public static void main(String[] args) {
        DiagonalTraverse dt = new DiagonalTraverse();
        Assert.assertArrayEquals(new int[] { 1, 2, 4, 7, 5, 3, 6, 8, 9 },
                dt.findDiagonalOrder(new int[][] {
                        { 1, 2, 3 },
                        { 4, 5, 6 },
                        { 7, 8, 9 }
                }));
    }

    // 00, 01, 10, 02, 11, 20, 12, 21, 22

    // 0,0 > 0,1 > 1,0 > 2,0 > 1,1 > 0,2 > 1,2 > 2,1 > 2,2
    /**
     *
     * Input:
     * [
     *  [ 1, 2, 3 ],
     *  [ 4, 5, 6 ],
     *  [ 7, 8, 9 ]
     * ]
     *
     * Output:  [1,2,4,7,5,3,6,8,9]
     *
     * */
}
