/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {

    public boolean isPalindrome(String s) {
        String trimmedString = trim(s);
        System.out.println(trimmedString);
        if (trimmedString.length() == 0)
            return true;
        if (trimmedString.length() == 1)
            return true;
        return isPalindrome(trimmedString, 0, trimmedString.length() - 1);
    }

    private boolean isPalindrome(String s, int l, int r) {
        if (l == r)
            return true;
        if (l == r - 1) {
            if (s.charAt(l) == s.charAt(r))
                return true;
            return false;
        }
        if (s.charAt(l) == s.charAt(r))
            return isPalindrome(s, l + 1, r - 1);
        return false;

    }

    private String trim(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i)) || Character.isAlphabetic(s.charAt(i)))
                result += String.valueOf(s.charAt(i));
        }
        return result.toLowerCase();
    }
}
// @lc code=end
