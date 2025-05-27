class Solution {
    public int differenceOfSums(int n, int m) {
        int s1=0, s2=0, sum=0;
        for(int i=1;i<=n;i++){
            if(i%n!=0){
                s1+=i;
            }
            else{
                s2+=i;
            }
            
            
        }
        sum=s1-s2;
        return sum;
        
    }
}