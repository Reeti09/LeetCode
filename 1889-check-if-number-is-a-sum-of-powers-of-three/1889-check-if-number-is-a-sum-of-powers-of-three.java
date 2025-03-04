class Solution {
    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 == 2) {
                return false; // If remainder is 2, it's not a sum of distinct powers of 3
            }
            n /= 3; // Move to the next power of three
        }
        return true; // If we never found '2' as a remainder, return true
    }
}
