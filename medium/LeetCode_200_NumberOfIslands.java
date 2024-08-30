/**
 * LeetCode - 200 - https://leetcode.com/problems/number-of-islands/
 *
 * My approach: DFS traversal solution.
 */

class Solution {
    private void visitLand(char[][] grid, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length) return;
        if (grid[i][j] == '0') return;
        grid[i][j] = '0';
        visitLand(grid, i-1, j);
        visitLand(grid, i+1, j);
        visitLand(grid, i, j-1);
        visitLand(grid, i, j+1);
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    visitLand(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
}