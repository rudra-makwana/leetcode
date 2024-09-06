/**
 * LeetCode - 79 - https://leetcode.com/problems/word-search/description/
 *
 * Idea: Use a DFS approach whenever a first character of word string matches with the matrix[i][j]
 * dfs appraoch will traverse on each 4 directions from the curr position of the matrix
 * to check the next element of the string.
 */

class Solution {
    public boolean exist(char[][] board, String word) {
        int m =board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)
                        && dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int currSize) {
        if (word.length() == currSize) return true;
        if (row < 0 || row >= board.length
                || col < 0 || col >= board[0].length
                || board[row][col] != word.charAt(currSize)) return false;
        char c =
        board[row][col] ^= 256;
        currSize++;
        boolean backtrack = dfs(board, word, row+1, col, currSize) ||
                dfs(board, word, row-1, col, currSize) ||
                dfs(board, word, row, col+1, currSize) ||
                dfs(board, word, row, col-1, currSize);
        board[row][col] ^= 256;
        return backtrack;
    }
}