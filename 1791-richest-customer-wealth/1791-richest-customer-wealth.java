class Solution {
    public int maximumWealth(int[][] accounts) {
        int l=accounts.length;
        int s=0;
        for(int i=0;i<l;i++){
            int s1=0;
            for(int j=0;j<accounts[0].length;j++){
                s1=s1+accounts[i][j];

            }
            s=  Math.max(s,s1);
            
        }
        return s;
        
    }
    
}