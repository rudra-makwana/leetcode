/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 * Approach 1: DFS appraoch
 */

class Solution {
    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null; // return null if we hit the empty node
        if (root == p || root == q) return root; // if we found any of the p or q return from here.
        //Let's say we found p and q is a descendent of p that means p is the answer and we won't find q any other calls
        TreeNode left = dfs(root.left, p, q); // check on left
        TreeNode right = dfs(root.right, p, q); // check on right
        if (left != null && right != null) return root; // if we found both p & q return the root as a result
        if (left != null) return left; // if left is not null but right is null then return left
        else return right; // else rigt. If both are null that means it is also null
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }
}