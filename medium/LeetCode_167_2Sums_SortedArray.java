/**
 * LeetCode - 167 - https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 */

/**
 * Best approach:
 * As the array is sorted we can use two pointers approach till we find the best solution.
 * In initial approach, we had to go through the already visited elements again.
 *
 * This approach says if the array is sorted that means larger element will be on the right and smaller will be on
 * the left.
 *
 * So we start with a two pointers approach, first pointer let's call it left pointing at 0 on the beginning. Right will
 * be pointing at the right-most element.
 *
 * We check the sum of elementAtLeft & elementAtRight is equal to target or not. If equals then return both indices.
 * Else if target is smaller than sum, meaning out left most selected element is not large enough so we increment left
 * pointer. Else our right most selected element is bigger and making our sum greater than target.
 *
 * Time Complexity = O(n) && Space Complexity O(1) due to two pointers only.
 */

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                res[0] = left + 1;
                res[1] = right + 1;
                break;
            } else if (sum < target) left++;
            else right--;
        }
        return res;
    }
}

/**
 * My first approach:
 * As array is already sorted that means to find a counter part of currently selected elements, we can simply apply
 * Binary Search logic. The problem with this logic is it can take upto O(n * log(n)) time in worst case.
 */
//class Solution {
//    private int findIndex(int[] nums, int target, int left) {
//        int right = nums.length;
//        while (left < right) {
//            int mid = (left + right)/2;
//            if (nums[mid] == target) return mid;
//            if  (nums[mid] > target) right = mid;
//            else left = mid + 1;
//        }
//        return -1;
//    }
//    public int[] twoSum(int[] numbers, int target) {
//        int[] res = new int[2];
//        for (int i = 0; i < numbers.length; i++) {
//            int j = findIndex(numbers, target - numbers[i], i+1);
//            if (j != -1) {
//                if (i > j) {
//                    res[0] = j + 1; res[1] = i + 1;
//                } else {
//                    res[0] = i + 1; res[1] = j + 1;
//                }
//            }
//        }
//        return res;
//    }
//}