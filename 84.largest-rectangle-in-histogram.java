import java.util.Stack;

/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] rb = populateRight(heights);
        int[] lb = populateLeft(heights);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int width = rb[i] - lb[i] - 1;
            int area = heights[i] * width;
            if (area > maxArea)
                maxArea = area;
        }
        return maxArea;
    }

    private int[] populateLeft(int[] heights) {
        int[] rb = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        rb[0] = -1;

        for (int i = 1; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                rb[i] = -1;
            } else {
                rb[i] = stack.peek(); 
            }
            stack.push(i);
        }
        return rb;
    }

    private int[] populateRight(int[] heights) {
        int[] rb = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(heights.length - 1);
        rb[heights.length - 1] = heights.length;

        for (int i = heights.length - 2; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                rb[i] = heights.length;
            } else {
                rb[i] = stack.peek();
            }
            stack.push(i);
        }
        return rb;
    }

}
// @lc code=end
