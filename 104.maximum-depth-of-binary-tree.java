/*
 * @lc app=leetcode id=104 lang=java
 *
 * [104] Maximum Depth of Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int ans = 0;

    public int maxDepth(TreeNode root) {
        maxDepth(root, 1);
        return ans;
    }

    private void maxDepth(TreeNode root, int depth) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            ans = Math.max(depth, ans);
        maxDepth(root.left, depth + 1);
        maxDepth(root.right, depth + 1);
    }
}
// @lc code=end
