import java.util.*;

class Solution {
    public int minOperations(int[] nums, int k) {
        // If k is greater than the smallest element, return -1 (impossible case)
        for (int num : nums) {
            if (num < k) return -1;
        }

        // Sort in descending order
        Arrays.sort(nums);
        
        int operations = 0;
        int i = nums.length - 1;

        // Iterate from largest to k
        while (i >= 0 && nums[i] > k) {
            operations++;

            // Skip duplicate values to ensure `h` is unique
            while (i > 0 && nums[i] == nums[i - 1]) {
                i--;
            }
            i--;  // Move to the next unique number
        }

        return operations;
    }
}
