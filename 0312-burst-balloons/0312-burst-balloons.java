class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[] points=new int[n+2];
        points[0]=1;
        points[n+1]=1;
        for(int i=0;i<n;i++){
            points[i+1]=nums[i];
        }
        int[][] dp=new int[n+2][n+2];
        for(int l=2;l<n+2;l++){
            for(int i=0;i<n+2-l;i++){
                int j=i+l;
                for (int k = i + 1; k < j; k++) {
                    // The total coins is the sum of three parts:
                    // 1. coins from bursting balloons in (i, k)
                    // 2. coins from bursting balloons in (k, j)
                    // 3. coins from bursting k itself, which has i and j as neighbors
                    int coins = dp[i][k] + dp[k][j] + (points[i] * points[k] * points[j]);
                    dp[i][j] = Math.max(dp[i][j], coins);
                }
            }
        }
        return dp[0][n+1];
        
    }
}