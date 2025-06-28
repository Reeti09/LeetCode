import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;

        // Step 1: Create a copy of the array and sort it to identify the k largest values.
        int[] sortedNums = Arrays.copyOf(nums, n);
        Arrays.sort(sortedNums); // Sorts in ascending order

        // Step 2: Use a hash map to store the k largest values and their required counts.
        // We take the last k elements from the sorted array.
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < k; i++) {
            // Get the k-th largest element from the end of the sorted array
            int val = sortedNums[n - 1 - i]; 
            counts.put(val, counts.getOrDefault(val, 0) + 1);
        }

        // Step 3: Iterate through the original 'nums' array.
        // Select elements that are among the k largest, respecting their original order
        // and the counts determined in the hash map.
        int[] result = new int[k];
        int resultIdx = 0; // Index for filling the result array

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            
            // Check if the current number is one of the k largest we need,
            // and if we still need more occurrences of this number.
            if (counts.containsKey(num) && counts.get(num) > 0) {
                result[resultIdx++] = num; // Add the number to the result subsequence
                counts.put(num, counts.get(num) - 1); // Decrement its count
                
                // Optimization: If we have already found k elements, we can stop.
                if (resultIdx == k) {
                    break; 
                }
            }
        }

        return result;
    }
}