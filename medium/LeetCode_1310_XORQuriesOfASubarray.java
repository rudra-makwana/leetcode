/**
 * LeetCode - 1310 - https://leetcode.com/problems/xor-queries-of-a-subarray/description
 *
 * My first approach iterative/brute force with O(n*m) time complexity and O(1) space
 *
 * Better approach =>
 * Intuition: x ^ y ^ x = y
 * We calculate XOR of at each index with prefix elements in arr
 * [0], [0,1], [0,2], [0,3], [0,4],..., [0,m],..., [0,n] <= XOR of m is XOR[m-1]^m
 * Now let's say I want to calculate [3,m] that means I need to exclude the XOR till 2 from XOR[m]
 * [3,m] = XOR[2] ^ XOR[m]
 * if starting is 0 nothing to exclude hence just return XOR[m] itself.
 *
 */


class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for(int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i-1] ^ arr[i];
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0] == 0) res[i] = prefix[queries[i][1]];
            else res[i] = prefix[queries[i][0]-1]^prefix[queries[i][1]];
        }
        return res;
    }
}