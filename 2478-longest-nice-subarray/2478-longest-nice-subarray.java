class Solution {
    public int longestNiceSubarray(int[] nums) {
        int l = 0, bitMask = 0, maxLength = 0;

        for (int r = 0; r < nums.length; r++) {
            // Shrink window if nums[r] shares bits with bitMask
            while ((bitMask & nums[r]) != 0) {
                bitMask ^= nums[l]; // Remove nums[l] from bitMask
                l++; // Move left pointer forward
            }

            bitMask |= nums[r]; // Add nums[r] to bitMask
            maxLength = Math.max(maxLength, r - l + 1); // Update max length
        }

        return maxLength;
    }
}
