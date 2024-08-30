/**
 * LeetCode - 98 - https://leetcode.com/problems/validate-binary-search-tree/description/
 *
 * Initial Approch: Using In-Order Traversal left -> parent -> right
 *
 * class Solution {
 *     private List<Integer> inOrderTraversal (TreeNode root, List<Integer> res) {
 *         if (root == null) return res;
 *         res = inOrderTraversal(root.left, res);
 *         res.add(root.val);
 *         res = inOrderTraversal(root.right, res);
 *         return res;
 *     }
 *
 *     public boolean isValidBST(TreeNode root) {
 *         List<Integer> order = inOrderTraversal(root, new ArrayList<Integer>());
 *         for(int i = 0; i < order.size() - 1; i++) {
 *             if (order.get(i+1) <= order.get(i)) return false;
 *         }
 *         return true;
 *     }
 * }
 *
 */