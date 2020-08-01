import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Assert;

public class VerticalOrderTreeTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();
        helper(root, 0, 0, map);


        List<List<Integer>> res = new ArrayList<>();
        map.values().stream().forEach(x -> {
            List<Integer> tmp = new ArrayList<>();
            x.values().stream().forEach(y -> {  Collections.sort(y); tmp.addAll(y); });
            res.add(tmp);
        });
        return res;
    }

    private void helper(TreeNode node, int x, int y, Map<Integer, Map<Integer, List<Integer>>> map) {
        if (node == null) {
            return;
        }

        if (map.containsKey(x)) {
            Map<Integer, List<Integer>> m = map.get(x);
            if (m.containsKey(y)) {
                m.get(y).add(node.val);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(node.val);
                m.put(y, list);
            }
        } else {
            Map<Integer, List<Integer>> m = new TreeMap<>();
            List<Integer> list = new ArrayList<>();
            list.add(node.val);
            m.put(y, list);
            map.put(x, m);
        }

        helper(node.left, x - 1, y + 1, map);
        helper(node.right, x + 1, y + 1, map);
    }


    public static void main(String[] args) {
        VerticalOrderTreeTraversal obj = new VerticalOrderTreeTraversal();
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> exp = new ArrayList<>(Arrays.asList(9));
        expected.add(exp);
        exp = new ArrayList<>(Arrays.asList(3, 15));
        expected.add(exp);
        exp = new ArrayList<>(Arrays.asList(20));
        expected.add(exp);
        exp = new ArrayList<>(Arrays.asList(7));
        expected.add(exp);

        Assert.assertTrue(expected.equals(obj.verticalTraversal(root)));


        TreeNode root2 = new TreeNode(0,
                new TreeNode(8),
                new TreeNode(1,
                        new TreeNode(3, null, new TreeNode(4, null, new TreeNode(7))),
                        new TreeNode(2, new TreeNode(5, new TreeNode(6), null), null)));

        List<List<Integer>> expected2 = new ArrayList<>();
        List<Integer> exp2 = new ArrayList<>(Arrays.asList(8));
        expected2.add(exp2);
        exp2 = new ArrayList<>(Arrays.asList(0, 3, 6));
        expected2.add(exp2);
        exp2 = new ArrayList<>(Arrays.asList(1, 4, 5));
        expected2.add(exp2);
        exp2 = new ArrayList<>(Arrays.asList(2, 7));
        expected2.add(exp2);

        Assert.assertTrue(expected2.equals(obj.verticalTraversal(root2)));
    }
}





















