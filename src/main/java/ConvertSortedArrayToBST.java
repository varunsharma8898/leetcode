public class ConvertSortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = helper(nums, 0, nums.length - 1);
        return root;
    }

    private TreeNode helper(int[] nums, int l, int r) {
        if (l >= r) {
            return null;
        }
        int mid = l + (r - l) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, 0, mid - 1);
        node.right = helper(nums, mid + 1, r);
        return node;
    }

    public class TreeNode {
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

}
