class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n=security.length;
        int[] nonInc=new int[n];
        for(int i=1;i<n;i++){
            if(security[i]>security[i-1]){
                nonInc[i]=0;
            }
            else{
                nonInc[i]=nonInc[i-1]+1;
            }
            
        }
        int[] nonDec=new int[n];
        for(int i=n-2;i>=0;i--){
            if(security[i]>security[i+1]){
                nonDec[i]=0;
            }
            else{
                nonDec[i]=nonDec[i+1]+1;
            }
            
        }
        List<Integer> l=new ArrayList<>();
        for(int i=time;i<n-time;i++){
            if(nonInc[i]>=time && nonDec[i]>=time){
                l.add(i);
            }
        }
        return l;

    }
}