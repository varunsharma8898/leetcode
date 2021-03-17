import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDnaSequences {

    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        if (s.length() < 10) {
            return res;
        }

        for (int i = 0; i <= s.length() - 10; i++) {
            String str = s.substring(i, i + 10);
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for (String key : map.keySet()) {
            if (map.get(key) > 1) {
                res.add(key);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        RepeatedDnaSequences obj = new RepeatedDnaSequences();
        List<String> res = obj.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        System.out.println(res);

        System.out.println(obj.findRepeatedDnaSequences("AAAAAAAAAAA"));


    }

}
