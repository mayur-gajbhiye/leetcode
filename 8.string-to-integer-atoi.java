/*
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 */

// @lc code=start
class Solution {

    String s;
    String res = "";
    double ans = 0;
    int mul = 1;
    boolean signChecked = false;
    boolean preZeroCheck=false;

    public int myAtoi(String s) {
        System.out.println("Integer.MAX: "+Integer.MAX_VALUE);
        System.out.println("Integer.MIN: "+Integer.MIN_VALUE);
        
        this.s = s;
        if (s.length() == 0)
            return 0;
        atoi(0);
        return (int) ans;
    }

    private void atoi(int i) {
        if (i >= s.length()){
            ans=mul*ans;
            return;
        }
        if (ans >= Integer.MAX_VALUE) {
            if (mul < 0)
                ans = Integer.MIN_VALUE;
            else
                ans = Integer.MAX_VALUE;
            return;
        }
        char c = s.charAt(i);
        int d = c - '0';
System.out.println(d);
        if(d==0 && !signChecked){
            preZeroCheck=true;
        }
        if (d < 10 && d > -1) {
            ans = ans * 10 + d;
            atoi(++i);
        } else if (c == ' ') {
            atoi(++i);
        }
        else if (!signChecked && !preZeroCheck) {
            if (ans == 0 && (c == '-' || c == '+')) {
                if (c == '-')
                    mul = -1;
                signChecked = true;
                atoi(++i);
            }
        } else {
            return;
        }
    }
}
// @lc code=end
