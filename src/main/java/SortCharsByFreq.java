import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

public class SortCharsByFreq {

    public String frequencySort(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> list = new LinkedList<>(freqMap.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        /**
         * Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
         *             @Override
         *             public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
         *                 return o2.getValue().compareTo(o1.getValue());
         *             }
         *         });
         * */
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        SortCharsByFreq obj = new SortCharsByFreq();
        Assert.assertEquals("eert", obj.frequencySort("tree"));
    }
}
