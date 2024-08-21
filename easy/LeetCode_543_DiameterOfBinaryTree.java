/**
 * LeetCode - 543 - https://leetcode.com/problems/diameter-of-binary-tree/description/
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

// Using DFS approach to get the diameter at each point
class Solution {
    int max = 0;
    public int getMaxHeight(TreeNode root) {
        if (root == null) return 0;
        int left = getMaxHeight(root.left);
        int right = getMaxHeight(root.right);
        if (max < (left + right)) max = left + right;
        return (left >= right) ? left + 1 : right + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int temp = getMaxHeight(root);
        return max;
    }
}