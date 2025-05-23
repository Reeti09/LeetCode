class Solution {
    public int maxSubArray(int[] nums) {
        int maxEnd=nums[0];
        int maxSoFar=nums[0];
        for(int i=1;i<nums.length;i++){
            maxSoFar=Math.max(nums[i], nums[i]+maxSoFar);
            maxEnd=Math.max(maxSoFar, maxEnd);
        }
        return maxEnd;
        
    }
}