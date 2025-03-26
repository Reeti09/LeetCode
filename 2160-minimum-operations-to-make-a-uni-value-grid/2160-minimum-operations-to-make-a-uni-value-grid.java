import java.util.*;

class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length;
        List<Integer> values = new ArrayList<>();

        // Flatten the grid and store in a list
        for (int[] row : grid) {
            for (int num : row) {
                values.add(num);
            }
        }

        // Check if transformation is possible
        int remainder = values.get(0) % x;
        for (int num : values) {
            if (num % x != remainder) return -1;
        }

        // Sort values to find median efficiently
        Collections.sort(values);
        int median = values.get(values.size() / 2);
        
        // Compute minimum operations
        int operations = 0;
        for (int num : values) {
            operations += Math.abs(num - median) / x;
        }

        return operations;
    }
}
