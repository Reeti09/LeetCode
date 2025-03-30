import java.util.*;

class Solution {
    public List<Integer> partitionLabels(String s) {
        // Step 1: Create a map to store the last index of each character
        Map<Character, Integer> lastIndex = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }

        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 0;

        // Step 2: Iterate through the string
        for (int i = 0; i < s.length(); i++) {
            // Update the end pointer to the farthest index of the current character
            end = Math.max(end, lastIndex.get(s.charAt(i)));

            // If we have reached the end of the current partition
            if (i == end) {
                // Add the length of the current partition to the result
                result.add(i - start + 1);
                // Move the start pointer for the next partition
                start = i + 1;
            }
        }

        return result;
    }
}
