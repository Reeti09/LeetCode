import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> lexicalOrder(int n) {
        // Initialize an ArrayList to store the lexicographically ordered numbers
        List<Integer> result = new ArrayList<>();
        // Start with the smallest lexicographically number 1
        int current = 1;
      
        for (int i = 0; i < n; ++i) {
            // Add the current number to the result list
            result.add(current);
          
            // Check if the next lexicographical step is to multiply by 10
            if (current * 10 <= n) {
                current *= 10; // If so, go down one level of the lexical tree
            } else {
                // If reached the end of this lexical level (e.g., n is 13 and current is 9),
                // or the increment leads past n, go up one level and increment
                while (current % 10 == 9 || current + 1 > n) {
                    current /= 10;
                }
                current++; // Increment to the next number in lexical order
            }
        }
      
        // Return the list containing the lexicographically ordered numbers
        return result;
    }
  
}