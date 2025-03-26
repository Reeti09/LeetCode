import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;

        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = n - 1, top = 0, bottom = m - 1;

        while (left <= right && top <= bottom) {
            // Traverse from left to right
            for (int i = left; i <= right; i++) result.add(matrix[top][i]);
            top++; 

            // Traverse from top to bottom
            for (int i = top; i <= bottom; i++) result.add(matrix[i][right]);
            right--;

            // Traverse from right to left (only if there's a remaining row)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) result.add(matrix[bottom][i]);
                bottom--;
            }

            // Traverse from bottom to top (only if there's a remaining column)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) result.add(matrix[i][left]);
                left++;
            }
        }
        return result;
    }
}
