/**
 *
 * LeetCode - 417 - https://leetcode.com/problems/pacific-atlantic-water-flow/description/
 *
 */

class Solution {
    private int[][] directions;
    private int m, n;
    private int[][] matrix;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        matrix = heights;
        directions = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacific);
            dfs(i, n-1, atlantic);
        }
        for (int i = 0; i < n; i++) {
            dfs(0, i, pacific);
            dfs(m-1, i, atlantic);
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(pacific[i][j] && atlantic[i][j]) res.add(List.of(i, j));
            }
        }
        return res;
    }

    private void dfs(int row, int col, boolean[][] ocean) {
        ocean[row][col] = true;
        for (int[] dir: directions) {
            int r = row + dir[0];
            int c = col + dir[1];
            if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length) continue;
            if (ocean[r][c] || matrix[r][c] < matrix[row][col]) continue;
            dfs(r, c, ocean);
        }
    }
}

/** Stack overflow error. Above one is with leetcode's editorial help.

 class Solution {
 int[][] visited; // 0 = not visited, 1 = pacific, 2 = atlantic, 3 = both, -1 = can't reach
 int[][] directions;

 private int dfs(int[][] heights, int row, int col, int prevHeight) {
 if (row < 0 || col < 0) return 1;
 if (row >= heights.length || col >= heights[0].length) return 2;
 if (visited[row][col] > prevHeight) return -1;
 if (visited[row][col] != 0) return visited[row][col];
 Set<Integer> t = new HashSet<>();
 for (int i = 0; i < 4; i++) {
 int[] dir = directions[i];
 int r = dfs(heights, row+dir[0], col+dir[1], heights[row][col]);
 visited[row][col] = r;
 if (r == 3) return r;
 else if (r == 1) t.add(r);
 else if (r == 2) t.add(r);
 }
 if (t.size() == 0) {
 visited[row][col] = -1;
 } else if (t.size() == 2) {
 visited[row][col] = 3;
 }
 return visited[row][col];
 }

 public List<List<Integer>> pacificAtlantic(int[][] heights) {
 int m = heights.length, n = heights[0].length;
 visited = new int[m][n];
 directions = new int[4][];
 directions[0] = new int[] {0, 1}; // right towards atlantic
 directions[1] = new int[] {1, 0}; // down towards atlantic
 directions[2] = new int[] {0, -1}; // left towards pacific
 directions[3] = new int[] {-1, 0}; // up towards pacific
 List<List<Integer>> res = new ArrayList();
 for (int i = 0; i < m; i++) {
 for (int j = 0; j < n; j++) {
 int val = dfs(heights, i, j, Integer.MAX_VALUE);
 if (val == 3) {
 List<Integer> t = new ArrayList<>();
 t.add(i);
 t.add(j);
 res.add(t);
 }
 }
 }
 return res;
 }
 }


 */
