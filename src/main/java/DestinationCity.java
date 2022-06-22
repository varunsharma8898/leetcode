import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DestinationCity {

    public String destCity(List<List<String>> paths) {
        String returnVal = "";
        Map<String, String> pathMap = new HashMap<>();
        for (List<String> list : paths) {
            pathMap.put(list.get(0), list.get(1));
        }
        for (String city : pathMap.keySet()) {
            String dest = pathMap.get(city);
            if (!pathMap.containsKey(dest)) {
                returnVal = dest;
            }
        }
        return returnVal;
    }
}
