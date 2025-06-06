import java.util.Stack;

class Solution {
    public String robotWithString(String s) {
        StringBuilder res = new StringBuilder(); // Our result string
        Stack<Character> t = new Stack<>(); // Our temporary buffer (stack)
        int n = s.length();

        // Step 1: Precompute suffix_min array
        // suffix_min[i] will store the lexicographically smallest character from s[i] to s[n-1]
        char[] suffixMin = new char[n + 1];
        suffixMin[n] = (char) ('z' + 1); // Initialize with a character greater than 'z'

        for (int i = n - 1; i >= 0; i--) {
            suffixMin[i] = (char) Math.min(s.charAt(i), suffixMin[i + 1]);
        }

        // Step 2: Iterate through the input string s and make decisions
        for (int i = 0; i < n; i++) {
            // Always move the current character from s to t
            t.push(s.charAt(i));

            // While t is not empty AND the top of t is less than or equal to the smallest
            // character remaining in the unprocessed part of s (suffixMin[i+1])
            while (!t.isEmpty() && t.peek() <= suffixMin[i + 1]) {
                // Pop from t and append to res
                res.append(t.pop());
            }
        }

        // Step 3: After processing all characters from s, pop any remaining characters from t
        // and append them to res
        while (!t.isEmpty()) {
            res.append(t.pop());
        }

        return res.toString(); // Convert StringBuilder to String and return
    }
}