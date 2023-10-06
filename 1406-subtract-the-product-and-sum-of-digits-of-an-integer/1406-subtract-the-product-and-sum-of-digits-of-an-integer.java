class Solution {
    public int subtractProductAndSum(int n) {
        int product=1,s=0,result;
        while(n>0){
            int r=n%10;
            product=product*r;
            s=s+r;
            
            n=n/10;
        }
        result=product-s;
        return result;
    }
}