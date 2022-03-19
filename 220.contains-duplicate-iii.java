import java.util.Iterator;
import java.util.Map;

/*
 * @lc app=leetcode id=220 lang=java
 *
 * [220] Contains Duplicate III
 */

// @lc code=start
class Solution {

    Map<Integer, Integer> map = new HashMap<>();

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length <= 1)
            return false;
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);
        return containsDuplicate(nums, 0, k, t);
    }

    private boolean containsDuplicate(int[] nums, int i, int k, int t) {
        if (i >= nums.length)
            return false;

            Iterator<Map.Entry<Integer, Integer>> iterator=map.entrySet().iterator();
        // for (Map<Integer, Integer> entry : map.entrySet()) {
        while(iterator.hasNext()){
            Map.Entry<Integer, Integer> entry=iterator.next();
            int mapNum = entry.getKey();
            int mapIndex = entry.getValue();
            if (mapIndex != i && Math.abs(i - mapIndex) <= k && Math.abs((long) nums[i] - (long) mapNum) <= t) {
                return true;
            }
        }
        return containsDuplicate(nums, ++i, k, t);
    }
}
// @lc code=end
