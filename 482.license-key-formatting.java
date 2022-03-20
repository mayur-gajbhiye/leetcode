/*
 * @lc app=leetcode id=482 lang=java
 *
 * [482] License Key Formatting
 */

// @lc code=start
class Solution {
    public String licenseKeyFormatting(String s, int k) {
        String tString = trim(s, 0, "").toUpperCase();
        System.out.println("tString: " + tString);
        String result = "";
        for (int i = tString.length(), skipper = 0; i >= 0; i--, skipper++) {
            System.out.println("skipper: " + skipper + ", i: " + i);
            if (skipper == k) {
                result = "-" + result;
                skipper = 0;
            } else {
                result = s.charAt(i) + result;
            }
        }

        return result;
    }

    private String trim(String s, int i, String tString) {
        if (i >= s.length())
            return tString;
        if (s.charAt(i) != '-' && (Character.isDigit(s.charAt(i)) || Character.isAlphabetic(s.charAt(i)))) {
            tString += String.valueOf(s.charAt(i));
        }
        return trim(s, ++i, tString);
    }

}
// @lc code=end
