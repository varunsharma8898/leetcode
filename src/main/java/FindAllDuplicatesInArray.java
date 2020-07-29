import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

public class FindAllDuplicatesInArray {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]) {
                res.add(nums[i]);
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }

//        res.add(2);res.add(3);
        return res;
    }

    public static void main(String[] args) {
        FindAllDuplicatesInArray obj = new FindAllDuplicatesInArray();
        List<Integer> expected = new ArrayList<>(Arrays.asList(2, 3));
        Assert.assertTrue(expected.equals(obj.findDuplicates(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 })));

        expected.clear();
        expected.add(1);
        Assert.assertTrue(expected.equals(obj.findDuplicates(new int[] {1, 1 })));
    }
}
