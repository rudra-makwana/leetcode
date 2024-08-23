/**
 * LeetCode - 542 - https://leetcode.com/problems/01-matrix/description/
 */

// Approach 1: Shortest path problem? Try with BFS then ;

/**
 * Created the following datastructure to keep the track of steps needed at i, j
 */

class Node {
    int row, col, steps;
    Node(int row, int col, int steps) {
        this.row = row;
        this.col = col;
        this.steps = steps;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] copy = mat;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean[][] traversed = new boolean[mat.length][mat[0].length];
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[i].length; j++) {
                if (copy[i][j] == 0) {
                    queue.add(new Node(i, j, 0));
                    traversed[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Node head = queue.remove();
            for (int i = 0; i < directions.length; i++) {
                int x = head.row + directions[i][0];
                int y = head.col + directions[i][1];
                if (x >= 0 && y >= 0 && x <= copy.length - 1 && y <= copy[x].length - 1 && !traversed[x][y]) {
                    traversed[x][y] = true;
                    copy[x][y] = head.steps + 1;
                    queue.add(new Node(x, y, copy[x][y]));
                }
            }
        }
        return copy;
    }
}