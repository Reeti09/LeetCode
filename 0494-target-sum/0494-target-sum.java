class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total=0;
        for(int num: nums){
            total+=num;
        }
        if((total+target)<0 ||(total+target)%2!=0) return 0;
        int subset=(total+target)/2;
        int[] dp=new int[subset+1];
        dp[0]=1;
        for(int num: nums){
            for(int w=subset;w>=num;w--){
                dp[w]+=dp[w-num];
            }
        }
        return dp[subset];
    }
}