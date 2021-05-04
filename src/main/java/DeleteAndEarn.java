public class DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {
        int[] map = new int[10001];
        for (int num : nums) {
            map[num] += num;
        }

        int prev = 0, curr = 0;
        for (int val : map) {
            int tmp = curr;
            curr = Math.max(curr, prev + val);
            prev = tmp;
        }
        return curr;
    }

    /**
     * This is basically similar to HouseRobber problem
     * */
}
