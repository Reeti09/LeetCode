import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;

    public int colorTheGrid(int m, int n) {
        List<int[]> validStates = new ArrayList<>();
        Map<String, Integer> stateIndex = new HashMap<>();

        // Generate all valid column states
        generateStates(m, 0, new int[m], validStates);

        // Map each state to an index for DP
        for (int i = 0; i < validStates.size(); i++) {
            stateIndex.put(Arrays.toString(validStates.get(i)), i);
        }

        int size = validStates.size();
        int[][] compatible = new int[size][size];

        // Precompute transitions: i -> j is valid if no row has same color
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (isCompatible(validStates.get(i), validStates.get(j))) {
                    compatible[i][j] = 1;
                }
            }
        }

        // DP array: dp[col][stateIndex]
        int[] dp = new int[size];
        Arrays.fill(dp, 1); // Initial column

        // For each column from 1 to n-1
        for (int col = 1; col < n; col++) {
            int[] nextDp = new int[size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (compatible[i][j] == 1) {
                        nextDp[j] = (nextDp[j] + dp[i]) % MOD;
                    }
                }
            }

            dp = nextDp;
        }

        int result = 0;
        for (int val : dp) result = (result + val) % MOD;

        return result;
    }

    // Generate all valid column colorings (no two adjacent same)
    private void generateStates(int m, int pos, int[] curr, List<int[]> res) {
        if (pos == m) {
            res.add(Arrays.copyOf(curr, m));
            return;
        }

        for (int color = 0; color < 3; color++) {
            if (pos > 0 && curr[pos - 1] == color) continue; // Skip same as above
            curr[pos] = color;
            generateStates(m, pos + 1, curr, res);
        }
    }

    // Check horizontal compatibility of two column states
    private boolean isCompatible(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[i]) return false;
        }
        return true;
    }
}
