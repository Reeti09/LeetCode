class Solution {
    // parent[i] stores the representative of the set for character (char)('a' + i)
    // Initially, parent[i] = i (each character is its own representative)
    int[] parent = new int[26]; 

    // Find operation with path compression
    private int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent[i]); // Path compression
    }

    // Union operation: merges two sets, making the smaller char's root the new root
    private void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);

        if (rootI != rootJ) {
            // The lexicographically smaller root becomes the parent of the larger root
            if (rootI < rootJ) {
                parent[rootJ] = rootI;
            } else {
                parent[rootI] = rootJ;
            }
        }
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        // Initialize DSU: each character is initially equivalent only to itself
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        // Process s1 and s2 to build equivalence relations
        for (int i = 0; i < s1.length(); i++) {
            char char1 = s1.charAt(i);
            char char2 = s2.charAt(i);
            union(char1 - 'a', char2 - 'a');
        }

        // Build the result string for baseStr
        StringBuilder result = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            // Find the smallest equivalent character (the root of its set)
            char equivalentChar = (char)('a' + find(c - 'a'));
            result.append(equivalentChar);
        }

        return result.toString();
    }
}