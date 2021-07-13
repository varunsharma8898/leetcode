import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SoryArrayByFreq {

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            list.add(num);
        }

        Collections.sort(list, (o1, o2) ->
                freqMap.get(o1) != freqMap.get(o2)
                        ? freqMap.get(o1).compareTo(freqMap.get(o2))
                        : o2 - o1
        );
        return list.stream().mapToInt(i -> i).toArray();
    }
}
