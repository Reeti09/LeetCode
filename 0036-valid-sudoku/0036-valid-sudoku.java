import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> rowSet = new HashSet<>();
        HashSet<Character> colSet = new HashSet<>();
        HashSet<Character> boxSet = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            rowSet.clear();
            colSet.clear();

            for (int j = 0; j < 9; j++) {
                // Check row
                if (board[i][j] != '.' && !rowSet.add(board[i][j])) {
                    return false;
                }

                // Check column
                if (board[j][i] != '.' && !colSet.add(board[j][i])) {
                    return false;
                }
            }
        }

        // Check each 3x3 sub-grid
        for (int block = 0; block < 9; block++) {
            boxSet.clear();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int rowIndex = 3 * (block / 3) + i;
                    int colIndex = 3 * (block % 3) + j;
                    char num = board[rowIndex][colIndex];

                    if (num != '.' && !boxSet.add(num)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
