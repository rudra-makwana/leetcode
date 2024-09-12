/**
 * LeetCode - 408 - https://leetcode.com/problems/valid-word-abbreviation/description/
 *
 */

class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int p1 = 0, p2 = 0;
        int l1 = word.length(), l2 = abbr.length();
        while (p1 < l1 && p2 < l2) {
            if (word.charAt(p1) == abbr.charAt(p2)) {
                p1++;
                p2++;
            } else if (abbr.charAt(p2) == '0') {
                return false;
            } else if (Character.isDigit(abbr.charAt(p2))) {
                String numb = "";
                while (p2 < l2 && Character.isDigit(abbr.charAt(p2))) {
                    numb += abbr.charAt(p2);
                    p2++;
                }
                if (numb.length() != 0) p1 += Integer.valueOf(numb);
            } else {
                return false;
            }
        }
        return p1 == l1 && p2 == l2;
    }
}