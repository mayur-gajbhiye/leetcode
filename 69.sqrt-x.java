/*
 * @lc app=leetcode id=69 lang=java
 *
 * [69] Sqrt(x)
 */

// @lc code=start
class Solution {

    public int mySqrt(int x) {
        if (x == 0)
            return x;
        if (x == 1)
            return x;
        int l = 1;
        int r = x / 2;
        return binarySearch(l, r, x);
    }

    private int binarySearch(int l, int r, int x) {
        int m = (l + r) / 2;
        if (m > x / m)
            return binarySearch(l, --m, x);
        if (m + 1 <= x / (m + 1))
            return binarySearch(++m, r, x);
        return m;
    }

}
// @lc code=end
