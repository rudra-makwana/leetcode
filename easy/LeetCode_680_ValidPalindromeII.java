/**
 *
 * LeetCode - 680 - https://leetcode.com/problems/valid-palindrome-ii/description/
 *
 * We need to check if string is a palindromic string or not. We are allowed to remove at most one character if we want.
 *
 * Meaning when we mismatch a character we can ignore it from the left portion otherwise we can ignore it from the right
 * portion.
 *
 * At mismatch, we can check if any of the substring[l+1, r] and substring[l, r-1] is palindromic or not.
 *
 */


class Solution {

    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        boolean skipped = false;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else if (skipped) {
                return false;
            } else {
                boolean b1 = true, b2 = true;

                int t1 = l+1, t2 = r;
                int k1 = l, k2 = r-1;
                while (t1 < t2 && k1 < k2) {
                    if (s.charAt(t1) != s.charAt(t2)) {
                        b1 = false;
                        break;
                    }
                    t1++; t2--;
                }
                t1 = l;
                t2 = r - 1;
                while (t1 < t2) {
                    if (s.charAt(t1) != s.charAt(t2)) {
                        b2 = false;
                        break;
                    }
                    t1++; t2--;
                }
                return b1 || b2;
            }
        }
        return true;
    }
}