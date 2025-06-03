class Solution {
    public boolean canPartition(int[] nums) {
        int targetSum=0;
        for(int num: nums){
            targetSum+=num;
        }
        if(targetSum%2!=0){
            return false;
        }
        targetSum=targetSum/2;
        boolean[] dp = new boolean[targetSum + 1];
        dp[0]=true;
        for(int num: nums){
            for(int j=targetSum;j>=num;j--){
                dp[j]=dp[j]|| dp[j-num];
            }
        }
        return dp[targetSum];
        
    }
}