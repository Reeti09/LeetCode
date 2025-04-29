public class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;

        // Step 1: Find the maximum element
        for (int num : nums) {
            max = Math.max(max, num);
        }

        long result = 0;
        int count = 0; // Count of max elements in current window
        int left = 0;

        // Step 2: Sliding window
        for (int right = 0; right < n; right++) {
            if (nums[right] == max) {
                count++;
            }

            // While the count of max elements in the window is >= k
            while (count >= k) {
                // All subarrays starting from left to right (inclusive) are valid
                result += n - right;

                // Shrink window from left
                if (nums[left] == max) {
                    count--;
                }
                left++;
            }
        }

        return result;
    }
}
