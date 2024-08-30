/**
 * LeetCode - 133 - https://leetcode.com/problems/clone-graph/description/
 *
 * Graph is connected and unidirection and cyclic.
 *
 * My first approach: Use recursion with memoization. Depth First Search Algorithm
 *
 * Memoization:
 * HashMap contianing the original node and its already cloned node. This will help us not to clone already cloned
 * nodes in the Graph.
 *
 * Recursice function:
 * 1. If node is null, return null
 * 2. If node is already cloned, return it's copy from Map.
 * 3. If it's not cloned then create a new cloned copy and create create cloned neighbours from original node.
 *
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> cloned;

    private Node clone(Node node) {
        if (node == null) return null;
        if (cloned.containsKey(node)) return cloned.get(node);
        Node res = new Node();
        res.val = node.val;
        List<Node> neighbors = new ArrayList<>();
        cloned.put(node, res);
        for (Node n: node.neighbors) {
            neighbors.add(cloned.getOrDefault(n, clone(n)));
        }
        res.neighbors = neighbors;
        return res;
    }

    public Node cloneGraph(Node node) {
        cloned = new HashMap<>();
        Node root = clone(node);
        return root;
    }
}

/**
 * BFS Approach. As this is a graph and we need to traverse over it we can use either of DFS and BFS
 * DFS creates the stack overflow problem due to recursice calls. So if we want to avoid DFS, we can do BFS.
 *
 *
 * class Solution {
 *     public Node cloneGraph(Node node) {
 *         if (node == null) return null;
 *         HashMap<Node, Node> cloned = new HashMap<>();
 *         Queue<Node> queue = new LinkedList<>();
 *         queue.add(node);
 *         cloned.put(node, new Node(node.val, new ArrayList<>()));
 *         while (!queue.isEmpty()) {
 *             Node temp = queue.remove();
 *             // cloned.put(temp, new Node(temp.val, new ArrayList<>()));
 *             for (Node n: temp.neighbors) {
 *                 if (!cloned.containsKey(n)) {
 *                     cloned.put(n, new Node(n.val, new ArrayList()));
 *                     queue.add(n);
 *                 }
 *                 cloned.get(temp).neighbors.add(cloned.get(n));
 *             }
 *         }
 *         return cloned.get(node);
 *     }
 * }
 *
 */