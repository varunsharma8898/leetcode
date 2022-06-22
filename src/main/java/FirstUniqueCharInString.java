public class FirstUniqueCharInString {

    public int firstUniqChar(String s) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map[c - 'a'] > 1) {
                continue;
            } else {
                return i;
            }
        }
        return -1;
    }
}
