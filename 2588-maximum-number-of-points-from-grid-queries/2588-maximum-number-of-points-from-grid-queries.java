import java.util.*;

public class Solution {  // Renamed from MaxPointsFromGridQueries to Solution
    public int[] maxPoints(int[][] grid, int[] queries) {
        int rows = grid.length, cols = grid[0].length;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        // Sort queries along with their original indices
        int[][] sortedQueries = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i] = new int[]{queries[i], i};
        }
        Arrays.sort(sortedQueries, Comparator.comparingInt(a -> a[0]));

        // Result array
        int[] result = new int[queries.length];

        // Min-Heap for processing cells in increasing order
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{grid[0][0], 0, 0});

        // Visited set
        boolean[][] visited = new boolean[rows][cols];
        visited[0][0] = true;

        int count = 0;  // Count of cells satisfying queries

        for (int[] query : sortedQueries) {
            int queryValue = query[0];
            int index = query[1];

            while (!minHeap.isEmpty() && minHeap.peek()[0] < queryValue) {
                int[] cell = minHeap.poll();
                int val = cell[0], r = cell[1], c = cell[2];

                count++;

                for (int[] dir : directions) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && !visited[nr][nc]) {
                        minHeap.offer(new int[]{grid[nr][nc], nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }

            result[index] = count;
        }

        return result;
    }
}
