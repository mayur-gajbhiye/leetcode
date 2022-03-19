import java.util.Map;

/*
 * @lc app=leetcode id=771 lang=java
 *
 * [771] Jewels and Stones
 */

// @lc code=start
class Solution {

    Map<Character, Integer> map = new HashMap<>();

    public int numJewelsInStones(String jewels, String stones) {
        populateJewelsMap(jewels, 0);
        return countJewels(stones, 0, 0);
    }

    private int countJewels(String stones, int i, int count) {
        if (i >= stones.length())
            return count;
        if (map.containsKey(stones.charAt(i)))
            return countJewels(stones, ++i, ++count);
        return countJewels(stones, ++i, count);
    }

    private void populateJewelsMap(String s, int i) {
        if (i >= s.length())
            return;
        if (!map.containsKey(s.charAt(i)))
            map.put(s.charAt(i), i);
        populateJewelsMap(s, ++i);
    }

}
// @lc code=end
