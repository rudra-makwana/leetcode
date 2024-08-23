/**
 * LeetCode Problem: 104
 * URL: https://leetcode.com/problems/maximum-depth-of-binary-tree
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
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;
        return (left > right) ? left : right;
    }
}

/**
 * This is a similar problem like LeetCode Problem number:543
 * [https://leetcode.com/problems/diameter-of-binary-tree/description/]
 *
 * Here we can just need to return the maximum hight for the root node.
 */