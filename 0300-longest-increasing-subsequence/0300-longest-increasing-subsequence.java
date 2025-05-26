class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        
        int[] T = new int[nums.length];
        // Initialize all values to 1 (every element is a subsequence of length 1)
        Arrays.fill(T, 1);
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    T[i] = Math.max(T[i], T[j] + 1);
                }
            }
        }

        // Find the maximum in the T array
        int maxLen = 0;
        for (int i = 0; i < T.length; i++) {
            maxLen = Math.max(maxLen, T[i]);
        }
        
        return maxLen;
    }
}
