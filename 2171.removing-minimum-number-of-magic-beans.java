import java.util.Arrays;

/*
 * @lc app=leetcode id=2171 lang=java
 *
 * [2171] Removing Minimum Number of Magic Beans
 */

// @lc code=start
class Solution {
    public long minimumRemoval(int[] A) {
        long N = A.length;
        long ans = Long.MAX_VALUE;
        long sum = 0;

        for (int n : A)
            sum += n;

        Arrays.sort(A);
        for (int i = 0; i < N; ++i)
            ans = Math.min(ans, sum - (N - i) * A[i]);
        return ans;
    }
}
// @lc code=end
