import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {

    public List<String> commonChars(String[] words) {
        int[] countMap = new int[26];
        for (char c : words[0].toCharArray()) {     // imp - fill the dict with initial data first
            countMap[c - 'a']++;
        }
        for (String word : words) {
            int[] currMap = new int[26];
            for (char c : word.toCharArray()) {
                currMap[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (currMap[i] < countMap[i]) {
                    countMap[i] = currMap[i];
                }
                // countMap[i] = Math.min(countMap[i], currMap[i]);
            }
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < countMap[i]; j++) {
                res.add(Character.toString((char) (i + 'a')));
            }
        }
        return res;
    }
}
