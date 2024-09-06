/**
 * LeetCode - 62 - https://leetcode.com/problems/unique-paths/
 *
 * My idea is to use a dynamic programming approach - top-to-bottom logic
 *
 * Logic:
 * 1. create an array of size m * n that will store the unique paths we can take from (0,0) position to reach there.
 * 2. dp[i][j] = dp[i-1][j] (coming from above) + dp[i][j-1] (coming from left)
 * 3. return dp[m-1][n-1]
 *
 * TC = O(n^2)
 *
 */

class Solution {
    private int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) dp[i][j] = dp[i-1][j];
                if (j > 0) dp[i][j] += dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}