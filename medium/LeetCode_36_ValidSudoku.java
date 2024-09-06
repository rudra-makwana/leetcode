/**
 * LeetCode - 36 - https://leetcode.com/problems/valid-sudoku/description/
 */

class Solution {

    Set<Character>[] rows, cols, boxes;

    public Solution() {
        rows = new HashSet[9];
        cols = new HashSet[9];
        boxes = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char val = board[i][j];
                if (val == '.') continue;

                int b = (i / 3) * 3 + j / 3;
                if (rows[i].contains(val) || cols[j].contains(val) || boxes[b].contains(val)) return false;
                rows[i].add(val);
                cols[j].add(val);
                boxes[b].add(val);
            }
        }
        return true;
    }
}