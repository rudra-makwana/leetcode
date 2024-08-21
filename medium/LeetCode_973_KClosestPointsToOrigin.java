/**
 * LeetCode - 973 - https://leetcode.com/problems/k-closest-points-to-origin/description/
 *
 * Approach 1:
 * 1. Create a function that will calculate a distance or just (x - x1)^2 + (y - y1)^2 instead of taking their square root
 * 2. Create a 2D array to store distance of point[i] from (0, 0) and point's index in actual input
 * 3. Sort the array
 * 4. Return first k elements from the sorted array.
 */

class Solution {
    private int calculateDistance(int x, int y) {
        return ((int)Math.pow(x, 2) + (int)Math.pow(y, 2));
    }

    public int[][] kClosest(int[][] points, int k) {
        if (k == points.length) return points;
        int[][] res = new int[k][2];
        int[][] distance = new int[points.length][2];
        for (int i = 0; i < points.length; i++) {
            distance[i][0] = calculateDistance(points[i][0], points[i][1]);
            distance[i][1] = i;
        }
        Arrays.sort(distance, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < k; i++) {
            res[i] = points[distance[i][1]];
        }
        return res;
    }
}