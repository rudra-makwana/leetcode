/**
 * LeetCode - 733 - https://leetcode.com/problems/flood-fill/description/
 */

class Solution {
    private int[][] fill(int[][] image, int sr, int sc, int sColor, int tColor) {
        if (sr >= 0 && sr < image.length && sc >= 0 && sc < image[0].length && image[sr][sc] == sColor){
            image[sr][sc] = tColor;
            image = fill(image, sr - 1, sc, sColor, tColor);
            image = fill(image, sr + 1, sc, sColor, tColor);
            image = fill(image, sr, sc + 1, sColor, tColor);
            image = fill(image, sr, sc - 1, sColor, tColor);
        }
        return image;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;
        return fill(image, sr, sc, image[sr][sc], color);
    }
}