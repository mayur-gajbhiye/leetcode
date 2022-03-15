/*
 * @lc app=leetcode id=344 lang=java
 *
 * [344] Reverse String
 */

// @lc code=start
class Solution {

    public void reverseString(char[] s) {
        int i = 0;
        while (i < s.length / 2) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
            i++;
        }
    }

}
// @lc code=end
