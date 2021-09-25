public class RemoveElementInPlace {
    public int removeElement(int[] nums, int val) {

        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[counter++] = nums[i];
            }
        }
        return counter;
    }

    public static void main(String[] args) {

        RemoveElementInPlace obj = new RemoveElementInPlace();
        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        // nums is passed in by reference. (i.e., without making a copy)
        int len = obj.removeElement(nums, 1);

        // any modification to nums in your function would be known by the caller.
        // using the length returned by your function, it prints the first len elements.
        for (int i = 0; i < len; i++) {
            System.out.print((nums[i]) + " ");
        }
    }
}
