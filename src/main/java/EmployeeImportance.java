import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeImportance {

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        return helper(id, map);
    }

    private int helper(int id, Map<Integer, Employee> map) {
        Employee node = map.get(id);
        int sum = node.importance;
        for (int childId : node.subordinates) {
            sum += helper(childId, map);
        }
        return sum;
    }
}
