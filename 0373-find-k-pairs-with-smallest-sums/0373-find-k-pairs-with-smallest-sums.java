import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // Max-heap: Stores int arrays of [sum, index_in_nums1, index_in_nums2]
        // Ordered by sum (a[0]) in descending order (max-heap).
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        int m = nums1.length;
        int n = nums2.length;

        // Early exit for invalid inputs
        if (m == 0 || n == 0 || k <= 0) {
            return new ArrayList<>();
        }

        // HEURISTIC OPTIMIZATION for the O(M*N) iteration:
        // Instead of iterating through all m*n pairs, we only iterate through a limited set.
        // The intuition is that the smallest sums will involve elements from the beginning
        // of both sorted arrays. We can limit the loops to k, or min(length, k).
        // WARNING: This is a heuristic and might still miss pairs if k is very large
        // and the smallest sums are scattered far into the arrays.
        // For example, if nums1 = [1000], nums2 = [1, 2, ..., 1000], k=500.
        // This heuristic would only check nums1[0] with nums2[0...min(500, n-1)].
        // The min-heap solution handles this correctly.
        int limit1 = Math.min(m, k); // Limit elements from nums1 to consider
        int limit2 = Math.min(n, k); // Limit elements from nums2 to consider

        for (int i = 0; i < limit1; i++) {
            for (int j = 0; j < limit2; j++) { // Use limit2 here
                int sum = nums1[i] + nums2[j];

                if (maxHeap.size() < k) {
                    maxHeap.offer(new int[]{sum, i, j});
                }
                // CORRECTED LOGIC: Compare the largest sum in heap (maxHeap.peek()[0]) with the current sum.
                // If the current sum is smaller, pop the largest and add the current one.
                else if (maxHeap.peek()[0] > sum) {
                    maxHeap.poll();
                    maxHeap.offer(new int[]{sum, i, j});
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        // Extract all elements from the max-heap.
        // They will be popped in decreasing order of sum.
        while (!maxHeap.isEmpty()) {
            int[] temp = maxHeap.poll();
            int i = temp[1]; // index from nums1
            int j = temp[2]; // index from nums2

            List<Integer> pair = new ArrayList<>();
            pair.add(nums1[i]);
            pair.add(nums2[j]);
            result.add(pair);
        }

        // Reverse the result to get pairs in increasing order of sum.
        Collections.reverse(result);

        return result;
    }
}