class Solution {
    public int subsetXORSum(int[] nums) {
        return helper(nums, 0, 0);
    }
    
    private int helper(int[] nums, int index, int xorValue) {
        if (index == nums.length) {
            return xorValue;  // Return XOR sum of the current subset
        }
        
        // Include the current element
        int include = helper(nums, index + 1, xorValue ^ nums[index]);
        
        // Exclude the current element
        int exclude = helper(nums, index + 1, xorValue);
        
        return include + exclude; // Sum both cases
    }
}
