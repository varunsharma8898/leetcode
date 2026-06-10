import java.util.Locale;

import org.junit.Assert;

public class FindDuplicateCharsInString {

    public int solution(String S) {
        if (S == null || S.length() == 0) return 0;
        String word = S.toLowerCase();
        int[] map = new int[26];
        for (char c : word.toCharArray()) {
            map[c - 'a']++;
        }

        int bCount = map['b' - 'a'];
        int count = 0;
        while (bCount > 0) {
            int nCount = map['n' - 'a'];
            if (nCount >= 2) {
                map['n' - 'a'] = nCount - 2;
                int aCount = map[0];
                if (aCount >= 3) {
                    map[0] = aCount - 3;
                    count++;
                }
            }

            bCount--;
        }

        return count;
    }

    public static void main(String[] args) {
        FindDuplicateCharsInString obj = new FindDuplicateCharsInString();
        Assert.assertEquals(1, obj.solution("NAABXXAN"));
        Assert.assertEquals(3, obj.solution("NAABXXANNAABXXANNAABXXAN"));
        Assert.assertEquals(0, obj.solution(""));
        Assert.assertEquals(0, obj.solution(null));
        Assert.assertEquals(0, obj.solution("testabc"));
        Assert.assertEquals(1, obj.solution("naabxxan"));
        Assert.assertEquals(2, obj.solution("NAANAAXNABABYNNBZ"));
    }

}
