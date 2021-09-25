import org.junit.Assert;

public class MaxRepeatingSubstring {

    public int maxRepeating(String sequence, String word) {
        StringBuilder sb = new StringBuilder(word);
        int count = 0;
        while (sequence.contains(sb.toString())) {
            count++;
            sb.append(word);
        }
        return count;
    }

    public static void main(String[] args) {
        MaxRepeatingSubstring obj = new MaxRepeatingSubstring();
        Assert.assertEquals(1, obj.maxRepeating("a", "a"));
        Assert.assertEquals(1, obj.maxRepeating("a", "a"));
    }
}
