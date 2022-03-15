import java.util.Stack;

/*
 * @lc app=leetcode id=503 lang=java
 *
 * [503] Next Greater Element II
 */

// @lc code=start
class Solution {

    Stack<Integer> stack = new Stack<>();
    int[] array;
    int[] nge;

    public int[] nextGreaterElements(int[] nums) {
        this.array = nums;
        this.nge = new int[array.length];
        stack.push(array[array.length - 1]);
        nge[array.length - 1] = -1;
        populateNGE(array.length - 2);
        for (int i = 0; i < nge.length; i++)
            System.out.print(nge[i] + ", ");
        return nge;
    }

    private void populateNGE(int i) {
        if (i < 0)
            return;
        while (!stack.isEmpty() && array[i] > stack.peek()) {
            stack.pop();
        }
        if (stack.isEmpty()) {
            nge[i] = -1;
        } else {
            nge[i] = stack.peek();
        }
        stack.push(array[i]);
        populateNGE(--i);
    }

}
// @lc code=end
