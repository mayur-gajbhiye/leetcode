import java.util.Map;

/*
 * @lc app=leetcode id=509 lang=java
 *
 * [509] Fibonacci Number
 */

// @lc code=start
class Solution {

    Map<Integer, Integer> map = new HashMap<>();

    public int fib(int n) {
        if (n == 0 || n == 1)
            return n;
        if (map.containsKey(n))
            return map.get(n);
        else
            map.put(n, fib(n - 1) + fib(n - 2));
        return map.get(n);
    }
}
// @lc code=end
