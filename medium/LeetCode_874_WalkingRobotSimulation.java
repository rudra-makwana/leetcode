/**
 * LeetCode - 874 - https://leetcode.com/problems/walking-robot-simulation/
 *
 * Approach:
 * 1. if command is to change dir to left or right do so
 * 2. if command is to move k position towards the direction then do it till we hit the wall/obstacles or we find the kth
 * position
 * 3. calculate the squares euclidean length of that coordinates from (0,0) -> x^2 + y^2
 *
 * We can convert the coordinates into a hashvalue that will be unique to that coordinates only so we can easily
 * check if the curr move will be taking us to the obstacles or not.
 *
 * Some hash functions idea:
 *
 * 1. hash = x + (HASH_MULTIPLIER * y)  <= HASH_MULTIPLIER should be greater than 2 * point's possible max value
 * In the following case, we can get max of (30,000) for x or y. So we need it to be > 60000
 *
 * 2. hash = str(x) + "_" + str(y) this will be also unique to each coordinates -> it can take O(m+n) extra time to
 * convert x and y to strings.
 *
 */

class Solution {
    private static final int HASHMUL = 60013; // for hashfunction

    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Integer> obsSet = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            obsSet.add(hashCord(obstacles[i][0], obstacles[i][1]));
        }
        int[][] directions = {
                {0, 1}, // North
                {1, 0}, // East
                {0, -1}, // South
                {-1, 0} // West
        };

        int[] curr = {0, 0};
        int max = 0;
        int dir = 0;

        for (int command: commands) {
            if (command == -1) {
                dir = (dir + 1)%4;
            } else if (command == -2) {
                dir = (dir + 3)%4;
            } else {
                int[] move = directions[dir];
                for (int i = 0; i < command; i++) {
                    int x = curr[0] + move[0];
                    int y = curr[1] + move[1];
                    if (obsSet.contains(hashCord(x, y))) break;
                    curr[0] = x;
                    curr[1] = y;
                }
                max = Math.max((curr[0]*curr[0])+(curr[1]*curr[1]), max);
            }
        }
        return max;
    }

    private int hashCord(int x, int y) {
        return x + HASHMUL * y; // this will be always unique for each (x,y)
    }
}