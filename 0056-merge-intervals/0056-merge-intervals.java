import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        // Step 1: Sort the intervals by their start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Create a list to store merged intervals
        List<int[]> merged = new ArrayList<>();

        // Step 3: Traverse each interval
        for (int[] interval : intervals) {
            // If merged is empty or no overlap, add interval
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                // Overlap exists -> merge by updating the end time
                merged.get(merged.size() - 1)[1] = Math.max(
                    merged.get(merged.size() - 1)[1], interval[1]
                );
            }
        }

        // Step 4: Convert List to 2D array and return
        return merged.toArray(new int[merged.size()][]);
    }
}
