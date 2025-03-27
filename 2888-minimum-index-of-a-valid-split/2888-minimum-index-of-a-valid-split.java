import java.util.*;

class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        Map<Integer, Integer> freq = new HashMap<>();

        // Step 1: Find the dominant element
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int dominant = -1;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > n / 2) {
                dominant = entry.getKey();
                break;
            }
        }

        if (dominant == -1) return -1; // No dominant element found

        // Step 2: Find the minimum valid split index
        int leftCount = 0;
        int totalCount = freq.get(dominant);

        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) == dominant) {
                leftCount++;
            }

            int leftLength = i + 1;
            int rightLength = n - leftLength;
            int rightCount = totalCount - leftCount; // Remaining occurrences in right subarray

            // Check if both subarrays have the dominant element as majority
            if (leftCount > leftLength / 2 && rightCount > rightLength / 2) {
                return i;
            }
        }

        return -1;
    }

    
}
