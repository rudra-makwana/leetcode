/**
 * LeetCode - 226 - https://leetcode.com/problems/invert-binary-tree/description/
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
    private TreeNode recursiveInvertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }

    private TreeNode iterativeInvertTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode tempQ = q.remove();
            TreeNode t = tempQ.left;
            TreeNode left = tempQ.right;
            TreeNode right = t;
            if (left != null) q.add(left);
            if (right != null) q.add(right);
        }
        return root;
    }

    public TreeNode invertTree(TreeNode root) {
        int method = 0;
        if (method == 0) {
            return recursiveInvertTree(root);
        } else {
            return iterativeInvertTree(root);
        }
    }
}