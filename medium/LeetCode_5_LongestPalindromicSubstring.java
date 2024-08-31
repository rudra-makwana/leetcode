/**
 * LeetCode - 5 - https://leetcode.com/problems/longest-palindromic-substring/description/
 */

class Solution {
    private int getPalindromeSize(int mid1, int mid2, String s) {
        while(mid1 >= 0 && mid2 < s.length() && s.charAt(mid1) == s.charAt(mid2)) {
            mid1--;
            mid2++;
        }
        return mid2 - mid1 - 1;
    }

    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int oddLength = getPalindromeSize(i, i, s);
            if (end-start < oddLength) {
                start = i - oddLength/2;
                end = i + oddLength/2;
            }

            int evenLength = getPalindromeSize(i, i+1, s);
            if (end-start < evenLength) {
                start = i - evenLength/2 + 1;
                end = i + evenLength/2;
            }
        }
        return s.substring(start, end+1);
    }
}