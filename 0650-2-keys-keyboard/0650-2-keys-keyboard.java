class Solution {
    public int minSteps(int n) {
        if(n==1) return 0;
        int steps=0;
        int i=2;
        while(n>1){
            while(n%i==0){
                steps+=i;
                n/=i;
            }
            i++;
        }
        return steps;
    }
}