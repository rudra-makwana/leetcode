/**
 * LeetCode - 124 - https://leetcode.com/problems/binary-tree-maximum-path-sum/
 *
 * Looking at the problem statement we can see it in smaller problems as we need to see it as maximum paths at each
 * nodes.
 *
 * for node a => b - a - c the max can be = b + a + c
 * but what if node a has a parent node. We cannot send sum of a, b & c but it will be max of a + Max(b, c)
 *
 * Look at the solution at the bottom.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int maxVal; // Will be updated at every nodes if needed

    private int dfs(TreeNode node) {
        if (node == null) return 0; // no node meaning the path value is 0
        int l = dfs(node.left); // left child path value
        int r = dfs(node.right); // right child path value
        int val = node.val;
        maxVal = Math.max(maxVal, l + r + val); // SingleVariableDP: change maxVal to current node's path if bigger than maxVal
        return Math.max(Math.max(l, r) + val, 0); // reason to check max between max(l, r) + v and 0 is that if our v might be large negative number then we want to ignore it in the max path
    }

    public int maxPathSum(TreeNode root) {
        maxVal = Integer.MIN_VALUE;
        dfs(root);
        return maxVal;
    }
}