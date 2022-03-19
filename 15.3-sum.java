import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {

    Map<Integer, Integer> map = new HashMap<>();
    int[] nums;
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        this.nums = nums;
        populateMap(0);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ", Value:" + entry.getValue());
        }
        threeSum(0, 1);
        list.listIterator().forEachRemaining(subList -> {
            subList.listIterator().forEachRemaining(System.out::print);
            System.out.println();
        });
        return list;
    }

    private void threeSum(int cur, int left, int right) {
        if (cur >= nums.length || cur == right - 1)
            return;
        if (left == right)
            threeSum(cur + 1, cur + 2, right);

    }

    // private void threeSum(int i, int j) {
    // System.out.println("I=" + i + ", J=" + j);
    // if (i > nums.length - 1)
    // return;
    // int ijSum = nums[i] + nums[j];
    // int hashK = -1 * ijSum;
    // if (map.containsKey(hashK)) {
    // if (map.get(hashK) != i && map.get(hashK) != j) {
    // List<Integer> subList = new ArrayList<>();
    // subList.add(nums[i]);
    // subList.add(nums[j]);
    // subList.add(nums[hashK]);
    // list.add(subList);
    // }
    // }
    // threeSum(j == nums.length - 1 ? ++i : i, j < nums.length ? ++j : j);
    // }

    private void populateMap(int i) {
        if (i > nums.length - 1)
            return;
        map.put(nums[i], i);
        populateMap(++i);
    }

}
// @lc code=end
