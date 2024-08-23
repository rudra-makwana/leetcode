/**
 * LeetCode - 125 - https://leetcode.com/problems/valid-palindrome/description/
 */

class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        s = s.toLowerCase();

        while (left < right) {
            char leftC = s.charAt(left);
            char rightC = s.charAt(right);
            if (((leftC >= 'a' && leftC <= 'z') || (leftC >= '0' && leftC <= '9')) && ((rightC >= 'a' && rightC <= 'z') || (rightC >= '0' && rightC <= '9'))) {
                if (leftC != rightC) return false;
                left++;
                right--;
            }
            if (leftC < '0' || (leftC > '9' && leftC < 'a') || leftC > 'z') {
                left++;
            }
            if (rightC < '0' || (rightC > '9' && rightC < 'a') || rightC > 'z') {
                right--;
            }
        }
        return true;
    }
}