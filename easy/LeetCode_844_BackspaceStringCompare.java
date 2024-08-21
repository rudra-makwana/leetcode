/**
 * LeetCode - 844 - https://leetcode.com/problems/backspace-string-compare/description/
 */

class Solution {
    public boolean backspaceCompare(String s, String t) {
        int b1 = 0, b2 = 0;
        int p1 = s.length() - 1, p2 = t.length() - 1;
        while (p1 >= 0 || p2 >= 0) {
            while (p1 >= 0) {
                if (s.charAt(p1) == '#'){
                    b1++;
                    p1--;
                }
                else if (b1 > 0) {
                    b1--;
                    p1--;
                }
                else break;
            }
            while (p2 >= 0) {
                if (t.charAt(p2) == '#') {
                    b2++;
                    p2--;
                }
                else if (b2 > 0) {
                    b2--;
                    p2--;
                }
                else break;
            }
            if (p1 >= 0 && p2 >= 0 && s.charAt(p1) != t.charAt(p2)) return false;
            if ((p1 >= 0) != (p2 >= 0)) return false;
            p1--;
            p2--;
        }
        return true;
    }
}