class Solution {
    public int minSteps(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1]=0;
        for(int i=2;i<=n;i++){
            for(int j=1;j<i;j++){
                if(i%j==0){
                    int steps=i/j;
                    dp[i]=Math.min(dp[i], dp[j]+steps);
                }
            }
        }
        return dp[n];
    }
}