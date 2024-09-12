/**
 *
 * LeetCode - 1235 - https://leetcode.com/problems/maximum-profit-in-job-scheduling/description/
 *
 * Bruteforce with recursion (dfs) and memoization
 *
 */


class Solution {
    private int[][] jobs;

    private int dfs(int curr) {
        if (curr == jobs.length) return 0;
        if (jobs[curr][3] != -1) return jobs[curr][3];

        int without = dfs(curr + 1); // excluding currJob

        int j = curr + 1;
        while (j < jobs.length && jobs[j][0] < jobs[curr][1]) j++; // will be switched to binary search problem

        int with = jobs[curr][2] + dfs(j);
        jobs[curr][3] = Math.max(with, without);
        return jobs[curr][3];
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        jobs = new int[startTime.length][4];
        for(int i = 0; i < startTime.length; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
            jobs[i][3] = -1;
        }
        Arrays.sort(jobs, (j1, j2) -> (j1[0] - j2[0]));
        return dfs(0);
    }
}