class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int N = n * n;
        int[] count = new int[N + 1];
        int missing = -1, repeated = -1;
        
        // Count occurrences of each number
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count[grid[i][j]]++;
            }
        }
        
        // Identify missing and repeated values
        for (int i = 1; i <= N; i++) {
            if (count[i] == 0) missing = i;
            if (count[i] == 2) repeated = i;
        }
        
        return new int[]{repeated, missing};
    }
}