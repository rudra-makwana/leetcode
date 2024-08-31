/**
 * LeetCode - 31 - https://leetcode.com/problems/next-permutation/description/
 *
 * Aprroach: two pointer method
 *
 * Intuition:
 * Ex: We have this following permutation
 * Curr Perm: 1 2 4 9 8 7 6 5 3
 * Next Perm: 1 2 5 3 4 6 7 8 9
 *
 * How it happened?
 * -> Started from right we found an element that is larger than it's right element. That will be i=3 meaning 4 (4 < 9)
 * -> Now we need to find the immediate big element from the selected one (4) from the right -> that will be 5. (5 > 4)
 * -> Swap them: 1 2 5 9 8 7 6 4 3
 * -> Now we need to sort the elements after i = 4 till the end. Because our curr one is bigger but we can get smaller
 * permutation after sorting the remaining element to ascending order from left to right because this will be the
 * smallest possible number after the swap. -> 1 2 5 3 4 6 7 8 9
 *
 * The next permutation of the above permutation must be larger than the this one unless the current one is the maximum.
 *
 *
 */

class Solution {
    private int[] swap(int p1, int p2, int[] nums) {
        int t = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = t;
        return nums;
    }

    public void nextPermutation(int[] nums) {
        int size = nums.length;
        if (size == 1) return;
        int i = size - 2;
        while(i >= 0 && nums[i] >= nums[i+1]) i--; // found the one of the indices that needs to swaped
        int j = size - 1;

        if (i >= 0) {
            while (j > i && nums[i] >= nums[j]) j--; // found the second index that needs to be swapped
            nums = swap(i, j, nums);
        }

        // soring the numbers behind the swaped digit on the left
        i = i+1;
        j = size-1;
        while (i < j) {
            nums = swap(i, j, nums);
            i++;
            j--;
        }
    }
}