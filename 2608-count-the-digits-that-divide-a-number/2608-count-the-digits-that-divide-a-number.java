class Solution {
    public int countDigits(int num) {
        int c = 0;
        int n=num;
        while(num!=0)
        {
            int r=num%10;
            if(n%r==0)
            {
                c++;
            }
            num/=10;
        }
        return c; 
    }
}