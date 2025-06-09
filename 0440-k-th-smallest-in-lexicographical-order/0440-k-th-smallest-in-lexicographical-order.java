class Solution {
    // Class level variable to store the upper limit.
    private int upperLimit;

    // Method to find k-th smallest number in the range of 1 to n inclusive.
    public int findKthNumber(int n, int k) {
        // Assign the upper limit.
        this.upperLimit = n;
        // Start with the smallest number 1.
        long current = 1;
        // Decrement k as we start with number 1 already considered.
        k--;

        // Loop until we find the k-th number.
        while (k > 0) {
            // Determine the count of numbers prefixed with 'current'.
            int count = getCount(current);
            // If k is larger than or equal to the count, skip this prefix.
            if (k >= count) {
                k -= count; // Decrement k by the count of numbers.
                current++; // Move to the next number.
            } else {
                // If k is smaller than the count, go deeper into the next level.
                k--; // We're considering a number (current * 10) in next step, hence decrement k.
                current *= 10; // Move to the next level by multiplying by 10.
            }
        }
        // The current number is the k-th smallest number.
        return (int) current;
    }

    // Helper method to count the numbers prefixed with 'current' within 'n'.
    public int getCount(long current) {
        // Find the next sibling in the tree (e.g., from 1 to 2, 10 to 20 etc.).
        long next = current + 1;
        // Initialize the count of numbers.
        long count = 0;

        // Loop until 'current' exceeds 'upperLimit'.
        while (current <= upperLimit) {
            // Add the delta between n and current to the count.
            // We take the minimum of delta and (next - current) to handle cases where
            // 'n' is less than 'next - 1' (e.g., when 'n' is 12 and range is 10 to 20).
            count += Math.min(upperLimit - current + 1, next - current);

            // Move both 'current' and 'next' one level down the tree.
            next *= 10;
            current *= 10;
        }
        // Return the count after casting it to an integer.
        return (int) count;
    }
}