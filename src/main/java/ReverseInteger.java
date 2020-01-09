public class ReverseInteger {

    public int reverse(int x) {
        int i = 0;
        int MAX = Integer.MAX_VALUE; //2,147,483,647 -- 214,748,364
        int MIN = Integer.MIN_VALUE; //-2,147,483,647
        while (Math.abs(x) > 0) {
            if (i > MAX / 10 || i == MAX && x % 10 > 7) {
                return 0;
            }
            if (i < MIN / 10 || i == MIN && x % 10 < -8) {
                return 0;
            }
            i = (i * 10) + (x % 10);
            x = x / 10;
        }
        return i;
    }


    /*
    *
    *
    * Given a 32-bit signed integer, reverse digits of an integer.

    Example 1:

    Input: 123
    Output: 321

    Example 2:

    Input: -123
    Output: -321

    Example 3:

    Input: 120
    Output: 21

    Note:
    Assume we are dealing with an environment which could only store integers
    within the 32-bit signed integer range: [−231,  231 − 1].

    For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

    *
    * */
}
