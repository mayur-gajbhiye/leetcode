import java.util.Map;

/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        int i = 0;
        while (i < nums.length) {
            int diff=target-nums[i];
            if(map.containsKey(nums[i])){
                return new int[]{i, map.get(nums[i])};
            }else{
                map.put(diff, i);
            }
            i++;
        }
        return new int[]{-1,-1};
    }
}
// @lc code=end
