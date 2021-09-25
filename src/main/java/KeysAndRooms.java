import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Assert;

public class KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        Stack<Integer> stack = new Stack();
        stack.push(0);

        while (!stack.isEmpty()) {
            int currentKey = stack.pop();
            for (int room : rooms.get(currentKey)) {
                if (!visited[room]) {
                    visited[room] = true;
                    stack.push(room);
                }
            }
        }

        for (boolean seen : visited) {
            if (!seen) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        //[[1],[2],[3],[]] => true
        //[[1,3],[3,0,1],[2],[0]] => false

        KeysAndRooms obj = new KeysAndRooms();

        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> one = new ArrayList(); one.add(1);
        List<Integer> two = new ArrayList(); two.add(2);
        List<Integer> three = new ArrayList(); three.add(3);
        List<Integer> four = new ArrayList();
        rooms.add(one);
        rooms.add(two);
        rooms.add(three);
        rooms.add(four);
        Assert.assertTrue(obj.canVisitAllRooms(rooms));
    }
}
