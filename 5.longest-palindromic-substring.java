/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    String s;
    String result = "";

    public String longestPalindrome(String s) {
        this.s = s;
        for (int i = 0; i < s.length(); i++) {
            String ans = longestPalindrome(i, i, i, "");
            System.out.println("i=" + i + ", ans=" + ans);
            if (ans.length() > result.length())
                result = ans;
        }
        return result;
    }

    private String longestPalindrome(int mid, int l, int r, String res) {
        if (l < 0 || r > s.length() - 1){
            return res;
        }
        if (mid == l && l == r)
            return longestPalindrome(mid, --l, ++r, String.valueOf(s.charAt(mid)));

        if (s.charAt(l) == s.charAt(r))
            return longestPalindrome(mid, l - 1, r + 1,
                    String.valueOf(s.charAt(l) + res + String.valueOf(s.charAt(r))));
        if (l + 1 == mid && r - 1 == mid) {
            if (s.charAt(l) == s.charAt(mid))
                return String.valueOf(s.charAt(l)) + res;
            if (s.charAt(r) == s.charAt(mid))
                return res + String.valueOf(s.charAt(r));
        }
        return res;
    }
}
// @lc code=end
