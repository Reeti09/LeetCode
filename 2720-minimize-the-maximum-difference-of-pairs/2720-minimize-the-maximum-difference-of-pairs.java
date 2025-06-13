class Solution {
    public int minimizeMax(int[] nums, int pairsToForm) {
        // Sort the array to prepare for binary search
        Arrays.sort(nums);
        // Number of elements in the array
        int arrayLength = nums.length;
        // Initialize binary search bounds
        int left = 0;
        int right = nums[arrayLength - 1] - nums[0] + 1;
      
        // Perform binary search to find the minimum maximum difference
        while (left < right) {
            int mid = (left + right) >>> 1; // Mid-point using unsigned bit-shift to avoid overflow
            // If enough pairs can be formed with this difference, go to left half
            if (countPairsWithDifference(nums, mid) >= pairsToForm) {
                right = mid;
            } else { // Otherwise, go to right half
                left = mid + 1;
            }
        }
        // Minimum maximum difference when the correct number of pairs are formed
        return left;
    }

    private int countPairsWithDifference(int[] nums, int maxDifference) {
        int pairCount = 0; // Count pairs with a difference less than or equal to maxDifference
        for (int i = 0; i < nums.length - 1; ++i) {
            // If a valid pair is found, increase count
            if (nums[i + 1] - nums[i] <= maxDifference) {
                pairCount++;
                i++; // Skip the next element as it's already paired
            }
        }
        return pairCount;
    }
}
