/**
 * LeetCode - 1371 - https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/
 *
 */

class Solution {
    private Map<Character, Integer> vowels;

    public Solution() {
        vowels = new HashMap<>();
        vowels.put('a', 1);  // a = 00001
        vowels.put('e', 2);  // e = 00010
        vowels.put('i', 4);  // i = 00100
        vowels.put('o', 8);  // o = 01000
        vowels.put('u', 16); // u = 10000

        // the above information only shows which bit to flip for that specific characters.
    }

    public int findTheLongestSubstring(String s) {
        // NeetCode - https://www.youtube.com/watch?v=o17MBWparrI
        int ans = 0;
        int mask = 0; // in the beginning mask will be 0 as there are all vowels with count 0.

        int[] bitmask = new int[32]; //bitmask datastructure
        Arrays.fill(bitmask, -2);
        bitmask[0] = -1;

        for (int i = 0; i < s.length(); i++) {
            mask = mask ^ vowels.getOrDefault(s.charAt(i), 0);
            if (bitmask[mask] != -2) {
                ans = Math.max(ans, i - bitmask[mask]);
            } else {
                bitmask[mask] = i;
            }
        }
        return ans;
    }
}

/**
 Example string s =  "aaxexbasfaoto"
 Our mask is 0 in the beginning.
 Ans = 0

 At i = 0 : charAt(0)  = a that means mask = mask XOR bit of 'a' = 0 ^ 00001 => 00001 shows a is in odd => bitmask[number(00001)] = bitmask[1] = 0
 At i = 1 : charAt(1)  = a that means mask = 00001 ^ 00001 => 00000 = 0 meaing a is even => ans=max(ans, i - (-1)) = Max(0, 1 - (-1)) = 2
 At i = 2 : charAt(2)  = x that means mask = 00000 ^ 0(x not a vowel) => 0 meaning ans=max(ans, i-(-1))=(2,3)=3
 At i = 3 : charAt(3)  = e that means mask = 00000 ^ 00010 => 00010 meaning e is odd curently => bitmask[00010] = bitmask[2] = 3
 At i = 4 : charAt(4)  = x that means mask = 00010 ^ 0 => 00010. bitmask[00010] != -2 meaning we can create a substring after last found odd e. ans=max(3,4-3)=3
 At i = 5 : charAt(5)  = b that means mask = 00010 ^ 0 => same as above so ans=max(3,5-3)=3
 At i = 6 : charAt(6)  = a that means mask = 00010 ^ 00001 = 00011 not found yet. bitmask[00011] = bitmask[3] = 6
 At i = 7 : chatAt(7)  = s that means mask = 00011 ^ 0 = 00011 and we have already seen it at index 6. ans=max(3,7-6)=3
 At i = 8 : charAt(8)  = f that means mask = 00011 ^ 0 = 00011 and seen it at 6: ans=max(3,8-6)=3
 At i = 9 : charAt(9)  = a that means mask = 00011 ^ 00001 = 00010 => a is even after the odd e at index 3. ans=max(3,9-3)=6
 At i = 10: charAt(10) = o that means mask = 00010 ^ 01000 = 01010 => e and o both are odd. bimask[01010] = bitmask[10] = 10
 At i = 11: charAt(11) = t that means mask = 01010 ^ 0 = 01010 = 10 exists in bitmask => ans=mask(6,11-10)=6
 At i = 12: charAt(12) = o that means mask = 01010 ^ 01000 = 00010 = 2 and bitmask[2] != -2 means ans=max(6,12-3)=9

 final answer 9
 */