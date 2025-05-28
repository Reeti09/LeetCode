class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int shift=0;
        while(m!=n){
            m=m>>1;
            n=n>>1;
            shift++;
        }
        return m<<shift;
        
    }
}