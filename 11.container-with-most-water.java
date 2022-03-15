import java.util.Stack;

/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {

    private int maxArea = 0;
    private int[] height;

    public int maxArea(int[] height) {
        this.height = height;
        findMaxArea(0, height.length - 1);
        return maxArea;
    }

    /**
     * This method helps moving pointer to a new location if height of ptr is less
     * Complexity O(n)
     * 
     * @param leftPtr
     * @param rightPtr
     */
    private void findMaxArea(int leftPtr, int rightPtr) {
        if (leftPtr == rightPtr)
            return;
        int h = Math.min(height[leftPtr], height[rightPtr]);
        int area = h * (rightPtr - leftPtr);
        if (area > maxArea)
            maxArea = area;
        if (height[leftPtr] == h || height[leftPtr] == height[rightPtr])
            findMaxArea(++leftPtr, rightPtr);
        else
            findMaxArea(leftPtr, --rightPtr);
    }

}
// @lc code=end
