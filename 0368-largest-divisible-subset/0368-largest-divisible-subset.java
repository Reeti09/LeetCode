

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums); // Sorting helps in ensuring divisibility condition
        int[] dp = new int[n]; // dp[i] stores the size of the largest subset ending at i
        int[] prev = new int[n]; // prev[i] stores the previous index in the subset
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int maxIndex = 0, maxSize = 1;

        // DP to find the largest subset
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxIndex = i;
            }
        }

        // Backtrack to construct the subset
        List<Integer> result = new ArrayList<>();
        for (int i = maxIndex; i >= 0; i = prev[i]) {
            result.add(nums[i]);
            if (prev[i] == -1) break;
        }

        return result;
    }

}
