/**
 * LeetCode - 701 - https://leetcode.com/problems/insert-into-a-binary-search-tree/
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val > root.val) {
            if (root.right != null) insertIntoBST(root.right, val);
            else root.right = new TreeNode(val);
        } else {
            if (root.left != null) insertIntoBST(root.left, val);
            else root.left = new TreeNode(val);
        }
        return root;
    }
}