class Solution {
    public int tallestBillboard(int[] rods) {
        int sum=0;
        for(int r:rods){
            sum+=r;
        }
        int[] dp=new int[sum+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        for(int r: rods){
            int[] nextDp=dp.clone();
            for(int d=0;d<=sum;d++){
                if(dp[d]<0){
                    continue;
                }
                int h=dp[d];
                int newDiff1=d+r;
                nextDp[newDiff1]=Math.max(nextDp[newDiff1], h);
                int shorter=h;
                int taller=h+d;
                if(d>=r){
                    int newDiff2=d-r;
                    int newShorter=shorter+r;
                    nextDp[newDiff2]=Math.max(nextDp[newDiff2], newShorter);


                }
                else{
                    int newDiff3=r-d;
                    int newShorter=taller;
                    nextDp[newDiff3]=Math.max(nextDp[newDiff3], newShorter);
                }
            }
            dp=nextDp;
        }
        return dp[0];
    }
}