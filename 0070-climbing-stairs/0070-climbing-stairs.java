class Solution {
    public int climbStairs(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        int oneStep=1;
        int twoStep=2;
        int total=0;
        for(int i=3;i<=n;i++)
        {
            total=oneStep+ twoStep;
            oneStep=twoStep;
            twoStep=total;
        }
        return total;



    }
    
}