/**
 * LeetCode - 297 - https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 *
 * Serialization - Create a comma separated preorder traversal string using DFS method
 * Deserialization - Do a DFS preorder traversal of the string till all the comma separated values are visited
 *
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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "null";
        String temp = String.valueOf(root.val);
        String left = serialize(root.left);
        String right = serialize(root.right);
        return temp + "," + left + "," + right;
    }

    private TreeNode deserialize(List<String> nodes) {
        if (nodes.get(0).equals("null")) {
            nodes.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes.get(0)));
        nodes.remove(0);
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(nodes));
        TreeNode root = deserialize(list);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));