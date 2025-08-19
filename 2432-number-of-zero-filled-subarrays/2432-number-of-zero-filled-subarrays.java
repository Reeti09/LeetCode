class Solution {
    // Method to calculate the number of zero-filled contiguous subarrays
    public long zeroFilledSubarray(int[] nums) {
        long totalCount = 0;  // Initialize total count of zero-filled subarrays
        int zeroCount = 0;   // Initialize count of consecutive zeros

        // Iterate through the array elements
        for (int value : nums) {
            // Reset zeroCount to 0 if the current element is not zero
            // Otherwise, increment zeroCount
            zeroCount = (value != 0) ? 0 : zeroCount + 1;
            // Add the current zeroCount to the total count
            totalCount += zeroCount;
        }

        return totalCount;  // Return the total count of zero-filled subarrays
    }
}