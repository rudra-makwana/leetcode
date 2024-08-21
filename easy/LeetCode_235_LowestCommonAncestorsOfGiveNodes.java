/**
 * LeetCode 235 - https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode temp = root;
        while (temp != null) {
            if (p.val <= temp.val && q.val >= temp.val) return temp;
            else if (q.val <= temp.val && p.val >= temp.val) return temp;
            else if (p.val < temp.val && q.val < temp.val) temp = temp.left;
            else temp = temp.right;
        }
        return temp;
    }
}