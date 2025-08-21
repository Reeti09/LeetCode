class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        int[][] height = new int[m][n];
        int totalCount = 0;

        // Step 1: Populate the height matrix
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (mat[i][j] == 1) {
                    height[i][j] = (i > 0) ? height[i - 1][j] + 1 : 1;
                }
            }
        }

        // Step 2: Count submatrices for each cell
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (mat[i][j] == 1) {
                    int minHeight = height[i][j];
                    // Iterate backwards to find all possible rectangle widths
                    for (int k = j; k >= 0; --k) {
                        minHeight = Math.min(minHeight, height[i][k]);
                        totalCount += minHeight;
                    }
                }
            }
        }

        return totalCount;
    }
}