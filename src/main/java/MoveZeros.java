public class MoveZeros {

    public void moveZeroes(int[] nums) {
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[counter++] = nums[i];
            }
        }
        for (int i = counter; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        MoveZeros obj = new MoveZeros();
        int[] test = new int[] { 0, 1, 0, 3, 12 };
        for (int num : test) System.out.print(num + " ");
        obj.moveZeroes(test);

        System.out.println();
        for (int num : test) System.out.print(num + " ");
    }
}
