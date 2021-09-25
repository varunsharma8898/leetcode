import java.util.Arrays;

public class SortArrayByParity {

    public int[] sortArrayByParity(int[] A) {

        int[] even = new int[A.length];
        int[] odd = new int[A.length];

        int i = 0, j = 0;
        for (int a : A) {
            if (a % 2 == 0) { // even
                even[i++] = a;
            } else { // odd
                odd[j++] = a;
            }
        }

//        Arrays.sort(even);
//        Arrays.sort(odd);
        for (int k = 0; k < j; k++) {
            even[i++] = odd[k];
        }

        return even;
    }

    public static void main(String[] args) {
        SortArrayByParity obj = new SortArrayByParity();
        int[] res = obj.sortArrayByParity(new int[] { 3, 1, 2, 4 });
        System.out.println(Arrays.toString(res));
    }
}
