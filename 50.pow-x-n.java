/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return -1;
        return x * myPow(x, n - 1);
    }
}
// @lc code=end
