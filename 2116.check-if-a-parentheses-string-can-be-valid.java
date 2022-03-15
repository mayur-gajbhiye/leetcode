import java.util.Stack;

/*
 * @lc app=leetcode id=2116 lang=java
 *
 * [2116] Check if a Parentheses String Can Be Valid
 */

// @lc code=start
class Solution {
    String s;
    String locked;
    Stack<Character> stack = new Stack<>();
    char openBracket = '(';
    char closeBracket = ')';
    boolean needClosed = true;

    public boolean canBeValid(String s, String locked) {
        this.s = s;
        this.locked = locked;
        if (s.length() <= 1)
            return false;
        fillStack(0);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        return true;
    }

    private boolean isValid(int i) {
        if (stack.isEmpty())
            return true;
        if (s.charAt(i) == closeBracket || s.charAt(i) == openBracket) {
            if(needClosed){
                if(stack.peek()==closeBracket){
                    isValid(--i);
                }
            }
        }
    }

    private void fillStack(int i) {
        if (i >= s.length())
            return;
        if (s.charAt(i) == openBracket || s.charAt(i) == closeBracket)
            stack.push(s.charAt(i));
        fillStack(++i);
    }
}
// @lc code=end
