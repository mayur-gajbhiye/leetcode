/*
 * @lc app=leetcode id=704 lang=java
 *
 * [704] Binary Search
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private static int search(int[] nums, int target, int s, int e) {
        if (s > e)
            return -1;
        int m = s + (e - s) / 2;
        if (nums[m] == target)
            return m;
        if (target < nums[m])
            return search(nums, target, s, m - 1);
        return search(nums, target, m + 1, e);
    }
}
// @lc code=end
