/**
 *
 * LeetCode - 54 - https://leetcode.com/problems/spiral-matrix/description/
 *
 * My approach:
 * 1. We need to spiral around the matrix that means we need to walk along side the walls of matrix. After completing
 * waling with a wall, we need to shrink that wall inwards the matrix.
 * 2. We can walk in four directions to spiral around and that directions are orderred.
 *
 * Algo:
 * 1. Start by walking right until we hit right wall.
 * 2. We hit the right wall. We traversed near the top wall. So shrinking top wall. (top += 1) We should not check
 * any elements above this
 * 3. Start walking downwards along with right wall. We hit a bottom wall. That means we need to shring the right wall
 * now. right -= 1;
 * 4. Start walking towards left till the end and shring the bottom wall. down -= 1
 * 5. Start walking towards upwards till we hit the top wall. After reaching we do left += 1
 *
 * we do it until our left <= right && top <= down. This ensures we are walking inside the shrinking matrix.
 *
 */

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int top = 0, down = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        int[][] directions = {
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
        };
        int i = 0;
        int r = 0, c = 0;
        res.add(matrix[r][c]);
        while (left <= right && top <= down) {
            int[] dir = directions[i];
            r += dir[0];
            c += dir[1];
            if (c > right) {
                c--;
                top++;
                i = 1;
            } else if (r > down) {
                r--;
                right--;
                i = 2;
            } else if (c < left) {
                c++;
                down--;
                i = 3;
            } else if (r < top) {
                r++;
                left++;
                i = 0;
            } else {
                res.add(matrix[r][c]);
            }
            System.out.println(left + "    " + right + "   " + top + "    " + down);
        }
        return res;
    }
}