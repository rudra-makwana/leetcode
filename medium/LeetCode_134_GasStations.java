/**
 * LeetCode - 134 - https://leetcode.com/problems/gas-station/description/
 *
 * Two things to check to solve this problem:
 * 1. Can we complete a cycle?
 * 2. If yes then from which gas station(position)?
 *
 * To answer the 1st question, we can easily identify that if our total gas excluding all the cost is less than 0 means
 * we don't have enough gas to complete cycle hence return -1;
 *
 * Now if we have enough gas then the next task would be to calculate till how far can we go from the index.
 * If our curr total gas becomes negative, that means we cannot start from any of the stations that we checked till now.
 *
 * For example,
 * - if cycle exists and the solution is first index (i = 0) that means our currGas will never become negative number
 * - if cycle exists and the solution is at the last index. That means our currGas will be negative before we reach to
 * the final gas station. (assumption: only one solution is present)
 * - if cycle exists and the solution is somewhere at i = k that means currGas after k will be always positive and
 * at (k-1) it would have been negative number. (assumption: only one solution is present)
 *
 */

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int size = cost.length;
        int currGain = 0, totalGain = 0, answer = 0;
        for (int i = 0; i < size; i++) {
            int diff = gas[i] - cost[i];
            totalGain += diff;
            currGain += diff;

            if (currGain < 0) {
                answer = i + 1;
                currGain = 0;
            }
        }
        return (totalGain >= 0) ? answer : -1;
    }
}