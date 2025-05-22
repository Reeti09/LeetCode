import java.util.*;

class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length;
        // Min-heap to track end points of currently active queries
        PriorityQueue<Integer> usedQuery = new PriorityQueue<>();
        // Max-heap to select queries with the farthest end point first
        PriorityQueue<Integer> availableQuery = new PriorityQueue<>(Collections.reverseOrder());

        // Sort queries by their start index
        Arrays.sort(queries, Comparator.comparingInt(a -> a[0]));

        int queryPos = 0;
        int appliedCount = 0;

        for (int i = 0; i < n; i++) {
            // Add all queries starting at index i to the availableQuery heap
            while (queryPos < queries.length && queries[queryPos][0] == i) {
                availableQuery.offer(queries[queryPos][1]);
                queryPos++;
            }

            // Adjust nums[i] by subtracting the number of active queries covering it
            nums[i] -= usedQuery.size();

            // Apply queries as needed to reduce nums[i] to zero
            while (nums[i] > 0 && !availableQuery.isEmpty() && availableQuery.peek() >= i) {
                int end = availableQuery.poll();
                usedQuery.offer(end);
                nums[i]--;
                appliedCount++;
            }

            // If nums[i] couldn't be reduced to zero, return -1
            if (nums[i] > 0) {
                return -1;
            }

            // Remove queries that end at index i from the usedQuery heap
            while (!usedQuery.isEmpty() && usedQuery.peek() == i) {
                usedQuery.poll();
            }
        }

        // Return the number of queries that can be removed
        return queries.length - appliedCount;
    }
}
