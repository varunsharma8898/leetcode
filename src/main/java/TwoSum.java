import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

public class TwoSum {

    /*
    * Given an array of integers, return indices of the two numbers such that
    * they add up to a specific target.
    * You may assume that each input would have exactly one solution,
    * and you may not use the same element twice.

    Example:

    Given nums = [2, 7, 11, 15], target = 9,

    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].

    */

    public static int[] twoSum(int[] nums, int target) {
        int[] indexes = new int[2];
        Map<Integer, Integer> myMap = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {

            if (index == 0) {
                myMap.put(nums[index], index);
            } else {
                int remainder = target - nums[index];
                if (myMap.containsKey(remainder)) {
                    indexes[0] = myMap.get(remainder);
                    indexes[1] = index;
                    return indexes;
                } else {
                    myMap.put(nums[index], index);
                }
            }

        }

        return indexes;
    }

    public static void main(String[] args) {

        int[] list = { 2, 7, 11, 15 };
        int[] indexes = twoSum(list, 9);
        Assert.assertArrayEquals(new int[] { 0, 1 }, indexes);

        int[] list2 = { 3, 2, 4 };
        int[] indexes2 = twoSum(list2, 6);
        Assert.assertArrayEquals(new int[] { 1, 2 }, indexes2);

        int[] list3 = { -3, 4, 3, 90 };
        int[] indexes3 = twoSum(list3, 0);
        Assert.assertArrayEquals(new int[] { 0, 2 }, indexes3);

    }

}
