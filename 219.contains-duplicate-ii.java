import java.util.Map;

/*
 * @lc app=leetcode id=219 lang=java
 *
 * [219] Contains Duplicate II
 */

// @lc code=start
class Solution {

    Map<Integer, Integer> map = new HashMap<>();

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        return containsDuplicate(nums, 0, k);
    }

    private boolean containsDuplicate(int[] nums, int i, int k) {
        if (i >= nums.length)
            return false;
        if (map.containsKey(nums[i]) && Math.abs(i - map.get(nums[i])) <= k) {
            return true;
        }
        map.put(nums[i], i);
        return containsDuplicate(nums, ++i, k);
    }
}
// @lc code=end
