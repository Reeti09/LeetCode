class Solution {
    public boolean isPowerOfThree(int n) {
        // A number that is a power of three must be positive.
        // The smallest power of three is 3^0 = 1.
        if (n <= 0) {
            return false;
        }

        // Repeatedly divide n by 3 as long as it's divisible.
        while (n % 3 == 0) {
            n /= 3;
        }
        
        // If n is a power of three, it will be reduced to 1 after all divisions.
        return n == 1;
    }
}
