import java.util.*;

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 0) return 0;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);  // Start with one candy for each child

        // First pass: from left to right
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Second pass: from right to left
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Calculate total candies
        int sum = 0;
        for (int candy : candies) {
            sum += candy;
        }
        return sum;
    }

    
}