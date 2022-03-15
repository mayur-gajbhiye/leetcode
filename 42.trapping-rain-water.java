import java.util.Stack;

/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {

    int[] oNGE;
    int[] oPGE;
    int[] height;

    public int trap(int[] height) {
        this.height = height;
        oNGE = new int[height.length];
        oPGE = new int[height.length];
        populateElements(height.length - 1, height[height.length - 1], false);
        populateElements(0, height[0], true);

        return calculateWaterTrapped(height.length - 1);
    }

    private void populateElements(int i, int maxHeight, boolean lookingForLeftMax) {
        if ((i < 0 && !lookingForLeftMax) || (i >= height.length && lookingForLeftMax))
            return;
        if (height[i] > maxHeight)
            maxHeight = height[i];

        if (lookingForLeftMax)
            oNGE[i] = maxHeight;
        else
            oPGE[i] = maxHeight;
        populateElements(!lookingForLeftMax ? --i : ++i, maxHeight, lookingForLeftMax);
    }

    private int calculateWaterTrapped(int i) {
        if (i < 0)
            return 0;
        int trapped = Math.min(oNGE[i], oPGE[i]) - height[i];
        return trapped + calculateWaterTrapped(--i);
    }

}
// @lc code=end
