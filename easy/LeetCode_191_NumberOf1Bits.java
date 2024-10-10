class Solution {
    public int hammingWeight(int n) {
        int c = 0;
        while (n != 0) {
            c++;
            n &= n-1;
        }

//        my solution - but slow
//        while (n != 0) {
//            if (n%2 == 1) c++; // if odd number then we will have 1 bit in the end
//            n = n>>1; 1 right shifting
//        }

        return c;
    }
}