class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0; // Not possible to form a triplet

        long maxTriplet = 0;
        
        // Step 1: Compute prefix maximums
        long[] maxPrefix = new long[n];
        maxPrefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            maxPrefix[i] = Math.max(maxPrefix[i - 1], nums[i]);
        }
        
        // Step 2: Compute suffix maximums
        long[] maxSuffix = new long[n];
        maxSuffix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxSuffix[i] = Math.max(maxSuffix[i + 1], nums[i]);
        }
        
        // Step 3: Iterate over `j` (middle element)
        for (int j = 1; j < n - 1; j++) {
            long leftMax = maxPrefix[j - 1];  // Best nums[i] before `j`
            long rightMax = maxSuffix[j + 1]; // Best nums[k] after `j`
            
            if (leftMax > nums[j]) {
                maxTriplet = Math.max(maxTriplet, (leftMax - nums[j]) * rightMax);
            }
        }
        
        return maxTriplet;
    }
}
