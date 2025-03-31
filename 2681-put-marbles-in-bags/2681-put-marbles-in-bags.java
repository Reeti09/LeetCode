import java.util.*;

class Solution {
    public long putMarbles(int[] weights, int k) {
        if (k == 1) return 0;  // If there's only one partition, no difference exists.

        List<Integer> pairwiseSums = new ArrayList<>();

        // Step 1: Compute the pairwise sums
        for (int i = 0; i < weights.length - 1; i++) {
            pairwiseSums.add(weights[i] + weights[i + 1]);
        }

        // Step 2: Sort the pairwise sums
        Collections.sort(pairwiseSums);

        long maxSum = 0, minSum = 0;
        
        // Step 3: Compute the sum of largest (k-1) and smallest (k-1) values
        for (int i = 0; i < k - 1; i++) {
            minSum += pairwiseSums.get(i);
            maxSum += pairwiseSums.get(pairwiseSums.size() - 1 - i);
        }

        return maxSum - minSum;
    }

    
}
