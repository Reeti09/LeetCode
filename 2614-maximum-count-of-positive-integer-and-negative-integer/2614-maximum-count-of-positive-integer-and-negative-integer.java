class Solution {
    public int maximumCount(int[] nums) {
        // Find the index of the first positive number
        int firstPositive = firstGreater(nums, 0);
        // Find the index of the first zero (or first non-negative)
        int firstZero = firstGreaterOrEqual(nums, 0);

        int negativeCount = firstZero; 
        int positiveCount = nums.length - firstPositive;

        return Math.max(negativeCount, positiveCount);
    }

    // Binary search to find the first number > target
    private int firstGreater(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // Binary search to find the first number >= target
    private int firstGreaterOrEqual(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
