/**
 * LeetCode - 994 - https://leetcode.com/problems/rotting-oranges/
 *
 * LeetCode editorial solution used.
 * Use BFS over DFS: Because we want to chagne each adjacents first before passing to next adjacents.
 *
 * We start by adding all the rotten fruits into the queue for bfs appraoch.
 * We add indicator to show that level is breaking here.
 *
 * Start minute passed from -1. -1 Because our queue starts from already rotten fruits. We can add -1 again to mark
 * adjacents' level to be completed.
 *
 * We start popping the rotten fruit one by one and mark their adjacents rotten if they are fresh. Add them to queue.
 * So we will have a next possible all the adjacents added to the queue.
 *
 * Algorithm:
 * 1. freshFruit = 0 && minutes = -1
 * 2. Initialize queue that holds the coordinates of rotten fruit
 * 3. Add all rotten fruits to queue and count all the fresh fruits
 * 4. Add -1,-1 (end point of the level) position to show that the all the rotten fruits before this point happened at the same time
 * 5. while queue not empty iterate:
 *      a. get coordinates by popping the queue
 *      b. if we found the the end point of level:
 *          i increment minutes counter
 *          ii. if queue is not empty that means we have next level yet to process. So add another end point for that
 *          level
 *      c. else we add all the valid adjacents with fresh to the queue after marking them rotten.
 *  6. if freshFruit is not zero that means we cannot make all fruits bad (why?) return -1
 *  7. else return count
 */


class Solution {
    public int orangesRotting(int[][] grid) {
        int count = 0;
        int fresh = 0;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) queue.offer(new Pair(i, j));
                if(grid[i][j] == 1) fresh++;
            }
        }
        queue.offer(new Pair(-1, -1));
        int[][] directions = { {-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while(!queue.isEmpty()) {
            Pair<Integer, Integer> co = queue.poll();
            int r = co.getKey();
            int c = co.getValue();
            if (r == -1) {
                count++;
                if (!queue.isEmpty()) queue.offer(new Pair(-1, -1));
            } else {
                for (int[] d : directions) {
                    int nR = r + d[0];
                    int nC = c + d[1];
                    if (nR >= 0 && nR < grid.length && nC >= 0 && nC < grid[r].length) {
                        if (grid[nR][nC] == 1) {
                            grid[nR][nC] = 2;
                            queue.offer(new Pair(nR, nC));
                            fresh--;
                        }
                    }
                }
            }
        }
        return fresh == 0 ? count - 1 : -1;
    }
}