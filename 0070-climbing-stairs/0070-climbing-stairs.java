class Solution {
    public int climbStairs(int n) {
        int a = 1,b = 1, result=0;
        int i = 2;
        if (n==1||n==2)
        {
            return n;
        }
        else
        {
            while(i<=n)
            {
                result=a+b;
                a=b;
                b=result;
                i++;
            }
        }
        return result;
    }
}