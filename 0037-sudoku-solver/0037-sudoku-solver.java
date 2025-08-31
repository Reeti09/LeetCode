class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    /**
     * Solves the Sudoku puzzle using backtracking.
     * @param board The Sudoku board.
     * @return true if a solution is found, false otherwise.
     */
    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // Find the next empty cell
                if (board[i][j] == '.') {
                    // Try to place digits from 1 to 9
                    for (char c = '1'; c <= '9'; c++) {
                        // Check if the current digit is valid in this position
                        if (isValid(board, i, j, c)) {
                            // Place the digit
                            board[i][j] = c;

                            // Recur to solve the rest of the puzzle
                            if (solve(board)) {
                                return true; // Solution found
                            } else {
                                // Backtrack: If the current placement doesn't lead to a solution,
                                // reset the cell and try the next digit
                                board[i][j] = '.';
                            }
                        }
                    }
                    // If no digit from 1-9 works, this path is a dead end.
                    // Return false to trigger backtracking in the previous recursive call.
                    return false;
                }
            }
        }
        // If all cells are filled, a solution is found
        return true;
    }

    /**
     * Checks if a digit can be placed in a given cell according to Sudoku rules.
     * @param board The Sudoku board.
     * @param row The row index.
     * @param col The column index.
     * @param c The digit to be placed.
     * @return true if the placement is valid, false otherwise.
     */
    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            // Check row
            if (board[row][i] == c) {
                return false;
            }
            // Check column
            if (board[i][col] == c) {
                return false;
            }
            // Check 3x3 sub-box
            // Formula to get the start of the 3x3 box: (row / 3) * 3, (col / 3) * 3
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false;
            }
        }
        return true;
    }
}
