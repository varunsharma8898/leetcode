public class RemoveDuplicatesInPlace {

    public int removeDuplicates(int[] nums) {

        int counter = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[counter++] = nums[i + 1];
            } else {
                nums[i + 1] = nums[i];
            }
        }
        return counter;
    }

    public static void main(String[] args) {

        RemoveDuplicatesInPlace obj = new RemoveDuplicatesInPlace();
        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        // nums is passed in by reference. (i.e., without making a copy)
        int len = obj.removeDuplicates(nums);

        // any modification to nums in your function would be known by the caller.
        // using the length returned by your function, it prints the first len elements.
        for (int i = 0; i < len; i++) {
            System.out.print((nums[i]) + " ");
        }
    }
}
