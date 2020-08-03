import org.junit.Assert;

public class DistributeCandies {

    public int[] distributeCandies(int candies, int num_people) {
        int[] people = new int[num_people];
        for (int give = 0; candies > 0; candies -= give) {
            people[give % num_people] +=  Math.min(candies, ++give);
        }
        return people;
    }

    public static void main(String[] args) {
        DistributeCandies dc = new DistributeCandies();
        Assert.assertArrayEquals(new int[] { 1, 2, 3, 1 }, dc.distributeCandies(7, 4));
        Assert.assertArrayEquals(new int[] { 5, 2, 3 }, dc.distributeCandies(10, 3));
    }
}
