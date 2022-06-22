import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EmployeeWithLessThanKBreaks {

    /*
     * Complete the 'employeeWithLesserThanKBreaks' function below.
     *
     * The function is expected to return a 2D_INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY employeeCalls
     *  2. INTEGER k
     */

    public static List<List<Integer>> employeeWithLesserThanKBreaks(List<List<Integer>> employeeCalls, int k) {
        List<List<Integer>> result = new ArrayList<>();

        Map<Integer, List<Node>> map = new HashMap<>();
        for (List<Integer> call : employeeCalls) {
            int empId = call.get(0);
            if (!map.containsKey(empId)) {
                map.put(empId, new ArrayList<>());
            }
            map.get(empId).add(new Node(call.get(0), call.get(1)));
        }

        for (Integer empId : map.keySet()) {
            // List<Node> list = map.get(empId);
            // if (q.size() == 1) {
            //     result.add(new ArrayList<Integer>(Arrays.asList(empId, 1)));
            //     continue;
            // }

            int count = getCountOfBreaks(map.get(empId));
            if (count < k) {
                List<Integer> res = new ArrayList<>();
                res.add(empId);
                res.add(count);
                result.add(res);
            }
        }
        return result;
    }

    private static int getCountOfBreaks(List<Node> list) {
        Collections.sort(list, (o1, o2) -> o1.key - o2.key);
        Node first = list.get(0);
        Node second;
        int breaks = 0;
        for (int i = 1; i < list.size(); i++) {
            second = list.get(i);
            if (second.key - first.val > 0) {
                breaks++;
                first = second;
            }
        }
        return breaks;
    }

    static class Node {

        int key, val;

        Node(int k, int v) {
            this.key = k;
            this.val = v;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int employeeCallsRows = Integer.parseInt(bufferedReader.readLine().trim());
        int employeeCallsColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> employeeCalls = new ArrayList<>();

        IntStream.range(0, employeeCallsRows).forEach(i -> {
            try {
                employeeCalls.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> result = EmployeeWithLessThanKBreaks.employeeWithLesserThanKBreaks(employeeCalls, k);

        result.stream()
                .map(
                        r -> r.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                )
                .map(r -> r + "\n")
                .collect(toList())
                .forEach(e -> {
                    try {
                        bufferedWriter.write(e);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

        bufferedReader.close();
        bufferedWriter.close();
    }

}
