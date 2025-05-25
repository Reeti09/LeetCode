import java.util.HashMap;

public class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        int palindromeLength = 0;
        boolean hasCenter = false;

        for (String word : words) {
            String reversed = new StringBuilder(word).reverse().toString();
            if (map.getOrDefault(reversed, 0) > 0) {
                // We can form a pair
                palindromeLength += 4;
                map.put(reversed, map.get(reversed) - 1);
            } else {
                // Store the current word
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        // Check for a central word like "aa", "bb", etc.
        for (String key : map.keySet()) {
            if (key.charAt(0) == key.charAt(1) && map.get(key) > 0) {
                hasCenter = true;
                break;
            }
        }

        if (hasCenter) {
            palindromeLength += 2;  // Use one symmetric word in the middle
        }

        return palindromeLength;
    }
}
