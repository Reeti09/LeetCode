class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        // Use a parent array to represent the disjoint set
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        // Union the equivalent characters from s1 and s2
        for (int i = 0; i < s1.length(); i++) {
            int char1 = s1.charAt(i) - 'a';
            int char2 = s2.charAt(i) - 'a';
            union(parent, char1, char2);
        }

        // Build the result string
        StringBuilder result = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            int root = find(parent, c - 'a');
            result.append((char) ('a' + root));
        }

        return result.toString();
    }

    // Find the root of the character's set
    private int find(int[] parent, int i) {
        if (parent[i] == i) {
            return i;
        }
        // Path compression
        return parent[i] = find(parent, parent[i]);
    }

    // Union two character's sets
    private void union(int[] parent, int i, int j) {
        int rootI = find(parent, i);
        int rootJ = find(parent, j);

        if (rootI != rootJ) {
            // Make the smaller character the parent
            if (rootI < rootJ) {
                parent[rootJ] = rootI;
            } else {
                parent[rootI] = rootJ;
            }
        }
    }
}