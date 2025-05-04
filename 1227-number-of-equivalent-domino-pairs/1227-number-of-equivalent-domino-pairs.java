public class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] count = new int[100];  // Since max value = 9*10 + 9 = 99
        int result = 0;
        
        for (int[] domino : dominoes) {
            int a = domino[0];
            int b = domino[1];
            int key = a < b ? a * 10 + b : b * 10 + a;

            result += count[key];  // All previous same dominoes make a new pair
            count[key]++;
        }
        
        return result;
    }
}
