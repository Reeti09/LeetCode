class Solution {
    public boolean isPowerOfTwo(int n) {
        // Method 2: Bit Manipulation (most efficient)
        // A number is a power of two if it's positive and has only one bit set to 1.
        // n & (n - 1) will be 0 for powers of two because all the bits will be cleared.
        // For example:
        // n = 8 (1000), n - 1 = 7 (0111)
        // 8 & 7 -> 1000 & 0111 = 0000 -> 0
        return n > 0 && (n & (n - 1)) == 0;
    }
}