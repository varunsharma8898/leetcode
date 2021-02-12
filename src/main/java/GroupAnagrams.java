import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> multiValueMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String strSorted = String.valueOf(chars);
            List<String> list = multiValueMap.getOrDefault(strSorted, new ArrayList<>());
            list.add(str);
            multiValueMap.put(strSorted, list);
        }
        for (List<String> val : multiValueMap.values()) {
            res.add(val);
        }
        return res;
    }

    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        List<List<String>> res = ga.groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" });
//        List<List<String>> res = ga.groupAnagrams(new String[] { "" });
//        List<List<String>> res = ga.groupAnagrams(new String[] { "a" });
        System.out.println(res);
    }
}
