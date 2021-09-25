import java.util.TreeSet;

import org.junit.Assert;

public class StoresAndHouses {

    /**
     * Binary Search algo O(n Log n) :
     * 1. Find the largest element in the set that is smaller than current house
     * 2. Find the smallest element in the set that is greater than current house
     * 3. Nearest stores should be shortest of the above two.
     * <p>
     * TreeSet ceiling() returns the lowest element in the set that is greater than or equal to passed element.
     * Similarly, treeset floor() returns largest element in the set that is smaller than or eq to passed element.
     */
    public int[] shortedDistance(int[] houses, int[] stores) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int store : stores) {
            set.add(store);
        }

        int[] res = new int[houses.length];
        for (int i = 0; i < houses.length; i++) {
            int house = houses[i];
            if (set.floor(house) != null && set.ceiling(house) != null) {
                res[i] = house - set.floor(house) <= set.ceiling(house) - house ? set.floor(house) : set.ceiling(house);
            } else if (set.floor(house) != null) {
                res[i] = set.floor(house);
            } else if (set.ceiling(house) != null) {
                res[i] = set.ceiling(house);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        StoresAndHouses obj = new StoresAndHouses();
        Assert.assertArrayEquals(new int[] { 5, 11, 16 },
                obj.shortedDistance(new int[] { 5, 10, 17 }, new int[] { 1, 5, 20, 11, 16 }));
    }

    /**
     *
     * You are given 2 arrays representing integer locations of stores and houses (each location in this problem is one-dementional). For each house, find the store closest to it.
     * Return an integer array result where result[i] should denote the location of the store closest to the i-th house. If many stores are equidistant from a particular house, choose the store with the smallest numerical location. Note that there may be multiple stores and houses at the same location.
     *
     * Example 1:
     *
     * Input: houses = [5, 10, 17], stores = [1, 5, 20, 11, 16]
     * Output: [5, 11, 16]
     * Explanation:
     * The closest store to the house at location 5 is the store at the same location.
     * The closest store to the house at location 10 is the store at the location 11.
     * The closest store to the house at location 17 is the store at the location 16.
     *
     * Example 2:
     *
     * Input: houses = [2, 4, 2], stores = [5, 1, 2, 3]
     * Output: [2, 3, 2]
     *
     * Example 3:
     *
     * Input: houses = [4, 8, 1, 1], stores = [5, 3, 1, 2, 6]
     * Output: [3, 6, 1, 1]
     *
     * */

}
