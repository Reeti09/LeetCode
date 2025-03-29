class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;

        // First pass: Compute new states
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int live = -board[i][j]; // Initialize with negative self-value

                // Count live neighbors
                for (int x = i - 1; x <= i + 1; x++) {
                    for (int y = j - 1; y <= j + 1; y++) {
                        if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] > 0) {
                            ++live;
                        }
                    }
                }

                // Apply game rules
                if (board[i][j] == 1 && (live < 2 || live > 3)) {
                    board[i][j] = 2;  // Alive → Dead (marked as 2)
                }
                if (board[i][j] == 0 && live == 3) {
                    board[i][j] = -1; // Dead → Alive (marked as -1)
                }
            }
        }

        // Second pass: Convert temporary states to final states
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0; // Convert back to dead
                } else if (board[i][j] == -1) {
                    board[i][j] = 1; // Convert back to alive
                }
            }
        }
    }
}
