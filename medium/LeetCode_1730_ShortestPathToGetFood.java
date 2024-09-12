/**
 * LeetCode - 1730 - https://leetcode.com/problems/shortest-path-to-get-food/description/
 *
 * DFS approach: Time Limit Exceeds
 *
 * BFS approach: Shortest Path? Choose BFS approach.
 * Similar like rotten oranges problem, we need to apply BFS visit till we find any food cell first.
 */


class Solution {
    public int getFood(char[][] grid) {
        int rowSize = grid.length, colSize = grid[0].length;
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // directions we can go
        boolean[][] visited = new boolean[rowSize][colSize]; // So we don't visit the same cell again

        Queue<int[]> q = new LinkedList<>();
        outerloop:
        for(int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (grid[i][j] == '*') { // We found a starting point
                    q.add(new int[]{i, j}); // add it to queue
                    visited[i][j] = true; // mark it visited
                    break outerloop; // only one starting point so break out of nested loops
                }
            }
        }

        int width = 0; // set the size to 0

        // add a sentinel position that will tell us that we have visited all the nodes on the same level
        q.add(new int[]{-1, -1});
        while(!q.isEmpty()) {
            int[] pos = q.remove();
            int row = pos[0], col = pos[1];
            if (row == -1 || col == -1) { // found a sentinel position
                // if q is empty that means we cannot travel anywhere so return -1
                if (q.size() == 0) return -1;
                width++; // increase the size as we are going to process next level in the graph
                q.add(new int[]{-1, -1}); // add the sentinel to the last position of the next level
                continue;
            }
            if(grid[row][col] == '#') return width; // found the food.
            // It will be always the nearest food as we are visiting level by level. So far available food would have
            // come after this level.


            for(int[] d: directions) { // visiting each directions
                int r = row + d[0];
                int c = col + d[1];
                if (r < 0 || c < 0 || r >= rowSize || c >= colSize) continue; // not a valid cell
                if (grid[r][c] == 'X' || visited[r][c]) continue; // cell has obstacle or visited already
                q.add(new int[]{r, c}); // not visited and a valid cell so add it to queue to process in future
                visited[r][c] = true; // mark it as visited
            }
        }
        return -1;
    }
}