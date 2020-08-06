import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;

public class NumbersWithSameConsecutiveDiff {

    public int[] numsSameConsecDiff(int num_digits, int diff) {

        if (num_digits == 1) {
            return new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        }

        Set<Integer> result = new HashSet<>();
        for (int i = 1; i < 10; i++) {
            dfs(num_digits - 1, i, diff, result);
        }
        return result.stream().mapToInt(i -> i).sorted().toArray();
    }

    private void dfs(int num_digits, int num, int diff, Set<Integer> result) {
        if (num_digits == 0) {
            result.add(num);
            return;
        }

        if (num % 10 + diff < 10) {
            int curr_number = (num * 10) + (num % 10 + diff);
            dfs(num_digits - 1, curr_number, diff, result);
        }

        if (num % 10 - diff >= 0) {
            int curr_number = (num * 10) + (num % 10 - diff);
            dfs(num_digits - 1, curr_number, diff, result);
        }
    }

    public static void main(String[] args) {
        NumbersWithSameConsecutiveDiff obj = new NumbersWithSameConsecutiveDiff();
        Assert.assertArrayEquals(new int[] { 181, 292, 707, 818, 929 }, obj.numsSameConsecDiff(3, 7));
        Assert.assertArrayEquals(new int[] { 10, 12, 21, 23, 32, 34, 43, 45, 54, 56, 65, 67, 76, 78, 87, 89, 98 },
                obj.numsSameConsecDiff(2, 1));
        Assert.assertArrayEquals(new int[] { 11, 22, 33, 44, 55, 66, 77, 88, 99 }, obj.numsSameConsecDiff(2, 0));
    }
}
