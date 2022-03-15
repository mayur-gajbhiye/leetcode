/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 */

// @lc code=start
class Solution {
    int result = 0;

    public int reverse(int x) {
        int mul = 1;
        if (x < 0)
            mul = -1;
        return mul * reverseInteger(x * mul);
    }

    private int reverseInteger(int num) {
        if (num <= 0)
            return result;
        int pop = num % 10;
        if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > 7))
            return 0;
        if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < -8))
            return 0;

        result = result * 10 + pop;
        return reverseInteger(num / 10);
    }
}
// @lc code=end
