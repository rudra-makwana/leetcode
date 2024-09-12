/**
 * LeetCode - 2220 - https://leetcode.com/problems/minimum-bit-flips-to-convert-number/description/
 *
 * Approach: Brian Kernighan’s Algorithm
 *
 * The problem is asking how many bits needs to be flipped in the start number to get a goal number. This means we need
 * to count the number of bits that are not similar in start and goal number.
 *
 * XOR operation: if two bits doesn't match then 1 otherwise 0. We can use it to see which bits are different.
 * int xor = start ^ goal
 *
 * now to calculate number of 1s in binary we need to use the following logic:
 * 1. loop until xor is not zero:
 *  a. increment the counter
 *  b. AND operation between XOR number and XOR-1.
 *  For example, 7 = 111 and 6 = 110 => 7&6 = 110 & 101 => 100 & 011 => 000 3 pass meaning 3 1s in main XOR
 *  example2: 8 = 1000 and 7 = 0111 => 7&8 = 0000 1 pass meanig one 1s in main XOR
 *  example3: 9 = 1001 and (9-1)=8=1000 => 9&8 = 1000 => 8&7 = 0000 2 pass = 2 1s
 *
 *  Operation of XOR with XOR-1 reduces one 1bit from main XOR. Iteratively doign till XOR becomes 0 means all 1s in
 *  the main XOR have been flipped to 0
 */

class Solution {
    public int minBitFlips(int start, int goal) {
        int xor = start ^ goal; // will give the XOR of these two values. XOR shows if same then 0 other 1 in binary
        int counter = 0;
        while (xor != 0) {
            counter++;
            xor &= (xor-1); // AND opeartion to count number of 1 bits in
        }
        return counter;
    }
}